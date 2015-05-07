#!/bin/bash

if [ "$TRAVIS_REPO_SLUG" == "osuWorks/osu-api-Java-Client" ] \
    && [ "$TRAVIS_PULL_REQUEST" == "false" ] \
    && [ "$TRAVIS_BRANCH" == "master" ]; then

    git config --global user.email "travis@travis-ci.org"
    git config --global user.name "travis-ci"

    mvn javadoc:javadoc scm-publish:publish-scm --settings $(dirname $0)/settings.xml
fi