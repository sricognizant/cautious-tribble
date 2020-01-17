# Evaluating Micronaut Part 1

## Software Requirements

In order to do this workshop, you need the following:

* Linux or MacOS with shell access, and the following installed:
    - `curl`.
    - `wget`.
    - `unzip`.
    - `git`.
* JDK 8.
* Docker. Please pull the following images before attending the workshop:
    - `consul`.
    - `mongo`.

Micronaut CLI

1. Install http://sdkman.io[SDKMAN!] if you haven't done so already.
2. Install Micronaut CLI:

    $ sdk install micronaut

3. Ensure the CLI is installed properly:

    $ mn --version
    | Micronaut Version: 1.2.6
    | JVM Version: 1.8.0_232