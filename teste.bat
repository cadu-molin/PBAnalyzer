@echo off
setlocal

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