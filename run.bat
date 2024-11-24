@echo off
set PATH_TO_FX="%~dp0lib"
javac --module-path %PATH_TO_FX% --add-modules=javafx.base,javafx.graphics,javafx.controls Main.java
java --module-path %PATH_TO_FX% --add-modules=javafx.base,javafx.graphics,javafx.controls Main
pause
