#!/bin/sh


#Handy script to deploy app to github pages(gh-pages)

# get comment
comment="$1"

sbt clean

sbt fullOptJS

if [ "$comment" == "" ]; then
comment="push form CI"
echo "no comment specified to deploy, using default : $comment"
fi

projectName="scalajs-react-template"

ghPagesPath="/Users/chandrasekharkode/Desktop/Kode/Programming/scalaprojects/chandu0101.github.io"

projectPath=${ghPagesPath}/${projectName}

mkdir -p ${projectPath}/js

cp index.html ${projectPath}

cp  js/${projectName}-opt.js ${projectPath}/js/

cp  js/${projectName}-jsdeps.js ${projectPath}/js/

cp  js/${projectName}-launcher.js ${projectPath}/js/

cd ${ghPagesPath}

git add ${projectName}

git commit -m "$comment"

git push