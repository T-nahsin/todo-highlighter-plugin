# TODO Highlighter Plugin

## Description
This IntelliJ IDEA plugin highlights `TODO` comments in Kotlin files. It scans the file and highlights the TODO comments in a distinct color. Additionally, it provides a tool window that lists all TODOs in the file and allows you to navigate directly to the comment.

## Installation

1. Download this repo as a ZIP or clone it.
2. Open it in IntelliJ IDEA as a plugin project.
3. Build the plugin using Build -> Prepare Plugin Module for Deployment.
4. Go to Settings -> Plugins -> Install Plugin from Disk... in IntelliJ.
5. Select the generated .zip from /build/distributions.

## Usage
1. Open a Kotlin file with TODO comments.
2. The comments will be highlighted automatically.
3. If the tool window is enabled, it will display a list of all TODOs in the file.

## Building & Running

1. Clone the repo into IntelliJ IDEA.
2. Open the project and run the plugin using Run > Run Plugin.

## Features

- Highlights TODO comments in Kotlin files.
- Yellow highlight for visibility.
- Works in any Kotlin project.
