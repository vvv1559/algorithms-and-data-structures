import argparse
import re
from pathlib import Path

from jinja2 import Environment, FileSystemLoader

import util.leetcode as lc

ROW_SIZE = 120

_CUR_DIR_ = Path(__file__).parent.resolve()
OUTPUT_PATH = _CUR_DIR_.parent.joinpath('leetcode/src/main/java/com/github/vvv1559/algorithms/leetcode')


def create_java_file(url, question_content):
    env = Environment(loader=FileSystemLoader(_CUR_DIR_))
    template = env.get_template('template-java.jinja2')
    class_name = build_class_name(question_content.get('title'))

    for snippet in question_content.get('codeSnippets'):
        if snippet.get('langSlug') == 'java':
            parts = {
                'difficulty': question_content.get('difficulty').lower(),
                'title': question_content.get('title'),
                'description': cleanup_java_content(question_content.get('content')),
                'originalLink': url,
                'className': class_name,
                'code': snippet.get('code').replace('Solution', class_name)
            }

            file_content = template.render(parts)
            result_file = "{}/{}.java".format(OUTPUT_PATH, class_name)
            with open(result_file, "w+") as f:
                f.write(file_content)


def create_md_file(url, question_content):
    env = Environment(loader=FileSystemLoader(_CUR_DIR_))
    template = env.get_template('template-md.jinja2')

    for snippet in question_content.get('codeSnippets'):
        if snippet.get('langSlug') == 'java':
            parts = {
                'difficulty': question_content.get('difficulty').lower(),
                'title': '{}. {}'.format(question_content.get('questionId'), question_content.get('title')),
                'description': cleanup_md_content(question_content.get('content')),
                'originalLink': url,
                'code': snippet.get('code')
            }

            file_content = template.render(parts)
            result_file = "{}/{}.{}.md".format(
                OUTPUT_PATH,
                question_content.get('questionId'),
                question_content.get('titleSlug')
            )
            with open(result_file, "w+") as f:
                f.write(file_content)


def build_class_name(title):
    parts = [word.capitalize() for word in title.replace('-', ' ').split(' ')]

    if parts[0][0].isdigit():
        parts[0] = '_' + parts[0]

    return ''.join(parts)


def cleanup_java_content(content):
    content = content.replace('\n', '') \
        .replace('&nbsp;', '') \
        .replace('<p>', '\r') \
        .replace('\r\r', '\r') \
        .replace('\r', '\n')

    content = re.sub('<[^<]+?>', '', content)
    result = []
    for row in content.split('\n'):
        while len(row) > ROW_SIZE:
            part = ''
            last_index = 0
            for word in row.split(' '):
                if len(part) + len(word) + 4 <= ROW_SIZE:
                    part = word if part == '' else (part + ' ' + word)
                else:
                    result.append(' * ' + part)
                    last_index = len(part)
                    break
            row = row[last_index + 1:]

        result.append(' * ' + row)

    return '\n'.join(result)


def cleanup_md_content(content):
    return content.replace('<strong>Input:</strong>', 'Input:') \
        .replace('<strong>Output:</strong>', 'Output:') \
        .replace('<strong>', '**') \
        .replace('</strong>', '**') \
        .replace('<pre>', '> ') \
        .replace('</pre>', '') \
        .replace('**Example', '\n**Example') \
        .replace('&nbsp;', '') \
        .replace('<ul>', '') \
        .replace('</ul>', '') \
        .replace('<li>', '* ') \
        .replace('</li>', ' ') \
        .replace('<code>', '`') \
        .replace('</code>', '`') \
        .replace('\t', '') \
        .replace('<p>', '') \
        .replace('</p>', '  ')


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        description='This tool used for the generation of template files for LeetCode tasks')
    parser.add_argument('type', choices=['md', 'java'], help='Type of the output file')
    parser.add_argument('url', help='URL of the question')

    args = parser.parse_args()
    content = lc.get_question_content(args.url)
    if args.type == 'md':
        create_md_file(args.url, content)
    else:
        create_java_file(args.url, content)
