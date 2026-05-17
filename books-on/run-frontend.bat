@echo off
REM Script para rodar o Frontend Books On

cd /d "%~dp0src\frontend\book-on-front"

echo.
echo ======================================
echo   Books On - Frontend Dev Server
echo ======================================
echo.

REM Verificar se Node está instalado
where node >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] Node.js não encontrado no PATH
    echo Por favor, instale Node.js https://nodejs.org
    pause
    exit /b 1
)

REM Verificar se npm está instalado
where npm >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] npm não encontrado no PATH
    pause
    exit /b 1
)

echo [1/2] Instalando dependências...
call npm install

echo [2/2] Iniciando servidor de desenvolvimento...
echo.
echo ✓ Frontend disponível em http://localhost:5173
echo ✓ Pressione Ctrl+C para parar
echo.

call npm run dev

pause
