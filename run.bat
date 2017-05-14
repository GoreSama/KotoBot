@echo off
COLOR C
TITLE KotoBot Console
"C:\Program Files\Java\jre1.8.0_111\bin\java.exe" -Xmx512m -cp deps/javadoc.jar;bin; maou.discordbot.Client
pause