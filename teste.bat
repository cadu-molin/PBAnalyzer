@echo off
chcp 65001 >nul
setlocal

set "FILE=%~dp0relatorio.json"

if exist "%FILE%" (
    del /f /q "%FILE%"
)

set JAR="C:\Projetos\Faculdade\TCC\PBAnalyzer\target\pbanalyzer-1.0-SNAPSHOT.jar"
set DIR_ANALISE="C:\Projetos\Faculdade\TCC\PBAnalyzer\mock"

echo Iniciando análise em lote...
echo.

for %%F in ("%DIR_ANALISE%\*.srw" "%DIR_ANALISE%\*.srd") do (
    echo Analisando arquivo: %%F
    java -jar %JAR% "%%F"
    echo ----------------------------
)

echo Análise concluída!
endlocal
pause