#!/bin/bash

mvn javadoc:aggregate scm-publish:publish-scm --settings $(dirname $0)/settings.xml