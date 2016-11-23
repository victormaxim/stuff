#!/bin/bash

folder=$1

if [[ -z $folder ]]; then
	echo -e "Usage: ./$(basename $0) <folder>"
	exit 0
fi

if [[ ! -d $folder ]]; then
	echo -e "Folder ($folder) doesn't exists"
	exit 0
fi

if [[ ! -d generic ]]; then
	echo -e "Folder (generic) doesn't exists"
	exit 0
fi

cp -r generic $folder/src/main/java/pages/

echo -e "Done"
