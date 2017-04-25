#!/bin/bash

ROOT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "${ROOT_DIR}"
cd ../output

echo "${ROOT_DIR}"

echo "Running javac Main.java"
javac Main.java

if [[ $? != 0 ]]; then
    echo "Failed to build."
else
    java Main
fi

