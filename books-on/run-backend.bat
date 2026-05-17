@echo off
REM Script para compilar e rodar o Backend Books On

cd /d "%~dp0src\backend"

echo.
echo ======================================
echo   Books On - Backend Build & Run
echo ======================================
echo.

REM Verificar se Maven está instalado
where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] Maven não encontrado no PATH
    echo Por favor, instale Maven ou adicione ao PATH
    pause
    exit /b 1
)

echo [1/3] Limpando build anterior...
call mvn clean -q

echo [2/3] Compilando projeto...
call mvn compile -q

if %errorlevel% neq 0 (
    echo [ERRO] Falha na compilação
    echo Verifique a versão do Java instalada
    echo Java 21 LTS é recomendado
    pause
    exit /b 1
)

echo [3/3] Iniciando servidor...
echo.
echo ✓ Backend iniciando em http://localhost:8081
echo ✓ Pressione Ctrl+C para parar
echo.

call mvn spring-boot:run

pause
