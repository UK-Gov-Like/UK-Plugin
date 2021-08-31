# UK Plugin
[![Discord badge](https://img.shields.io/badge/discord-working-purple.svg)](https://discord.gg/MvTQRAs)
[![CodeFactor](https://www.codefactor.io/repository/github/uk-gov-like/uk-plugin/badge)](https://www.codefactor.io/repository/github/uk-gov-like/uk-plugin)
![Mainteined](https://img.shields.io/badge/Maintained-yes-green.svg)

Welcome to the UK Plugin repository! This is a meme project based on a news that UK Gov uses excel to register all SARS-CoV-2 cases and deaths.

## What is the purpose of the plugin?

First at all, it's a **Minecraft Spigot** plugin, which loads on 1.17 version with total compatibility, with the focuses on creating a bank plugin, **that uses Excel as Database** (.xsl files), to register all the transactions and accounts balances.

## Building the plugin (for developers)

To build the plugin, you need to **clone the project**:

`git clone https://github.com/UK-Gov-Like/UK-Plugin.git`

After that, you'll have a **UK-Plugin folder**, now you can run the gradlew command to build the project.

The command will depends of your Operating System.

Windows:
`gradlew.bat build`

Linux/MacOS:
`./gradlew build`

##### **And now, you have a compiled .jar file in `builds/libs` folder.**