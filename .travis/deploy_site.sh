#!/bin/bash

if [ "$TRAVIS_REPO_SLUG" == "osuWorks/osu-api-Java-Client" ] \
        && [ "$TRAVIS_PULL_REQUEST" == "false" ] \
        && [ "$TRAVIS_BRANCH" == "master" ]; then
    mvn javadoc:aggregate scm-publish:publish-scm --settings $(dirname $0)/settings.xml
fi