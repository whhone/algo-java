#!/bin/bash

ROOT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "${ROOT_DIR}"
cd ../output

echo "Running javac Main.java" >> /dev/stderr
javac Main.java

if [[ $? != 0 ]]; then
    echo "Failed to build." >> /dev/stderr
else
    echo "Running time java Main" >> /dev/stderr
    echo "----------------------" >> /dev/stderr
    time java Main
fi

