/* eslint-disable @typescript-eslint/no-explicit-any */
import {
    Mail,
    Lock,
    Eye,
    BookOpen,
    Tag,
    EyeOff,
    Heart,
    User,
    AlertCircle,
    CheckCircle,
    Loader
} from "lucide-react";
import { useState } from "react";
import { api } from "../services/api";

function Login() {
    const [isLogin, setIsLogin] = useState(true);
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState<{ type: "success" | "error"; text: string } | null>(null);
    
    const [loginEmail, setLoginEmail] = useState("");
    const [loginPassword, setLoginPassword] = useState("");
    
    const [registerUsername, setRegisterUsername] = useState("");
    const [registerEmail, setRegisterEmail] = useState("");
    const [registerPassword, setRegisterPassword] = useState("");
    const [registerConfirmPassword, setRegisterConfirmPassword] = useState("");
    const [registerCpf, setRegisterCpf] = useState("");

    const validateEmail = (email: string) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    };

    const validateCpf = (cpf: string) => {
        return cpf.replace(/\D/g, "").length === 11;
    };

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        setMessage(null);

        if (!loginEmail || !loginPassword) {
            setMessage({ type: "error", text: "Por favor, preencha todos os campos" });
            return;
        }

        if (!validateEmail(loginEmail)) {
            setMessage({ type: "error", text: "Email inválido" });
            return;
        }

        setLoading(true);
        try {
            const response = await api.post("/v1/auth/login", {
                email: loginEmail,
                password: loginPassword
            });
            setMessage({ type: "success", text: "Login realizado com sucesso!" });
            localStorage.setItem("token", response.data.token);
            setTimeout(() => {
                window.location.href = "/home";
            }, 1500);
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        } catch (error: any) {
            const errorMessage = error.response?.data?.message || "Erro ao fazer login. Verifique suas credenciais.";
            setMessage({ type: "error", text: errorMessage });
        } finally {
            setLoading(false);
        }
    };

    const handleRegister = async (e: React.FormEvent) => {
        e.preventDefault();
        setMessage(null);

        if (!registerUsername || !registerEmail || !registerPassword || !registerConfirmPassword || !registerCpf) {
            setMessage({ type: "error", text: "Por favor, preencha todos os campos" });
            return;
        }

        if (!validateEmail(registerEmail)) {
            setMessage({ type: "error", text: "Email inválido" });
            return;
        }

        if (registerPassword !== registerConfirmPassword) {
            setMessage({ type: "error", text: "As senhas não conferem" });
            return;
        }

        if (registerPassword.length < 6) {
            setMessage({ type: "error", text: "A senha deve ter no mínimo 6 caracteres" });
            return;
        }

        if (!validateCpf(registerCpf)) {
            setMessage({ type: "error", text: "CPF inválido" });
            return;
        }

        setLoading(true);
        try {
            await api.post("/v1/auth/register", {
                username: registerUsername,
                email: registerEmail,
                password: registerPassword,
                cpf: registerCpf.replace(/\D/g, "")
            });
            setMessage({ type: "success", text: "Registro realizado com sucesso! Redirecionando para login..." });
            setTimeout(() => {
                setIsLogin(true);
                setRegisterUsername("");
                setRegisterEmail("");
                setRegisterPassword("");
                setRegisterConfirmPassword("");
                setRegisterCpf("");
                setMessage(null);
            }, 2000);
        } catch (error: any) {
            const errorMessage = error.response?.data?.message || "Erro ao registrar. Tente novamente.";
            setMessage({ type: "error", text: errorMessage });
        } finally {
            setLoading(false);
        }
    };
    return (
        <div
            className="
                flex
                flex-col
                lg:flex-row
                min-h-screen
                bg-gray-50
            "
        >
            {/* Left side - Logo and info (hidden on mobile, shown on lg+) */}
            <div className="hidden lg:flex lg:w-1/2 relative overflow-hidden">
                <img
                    src="/src/assets/Gemini_Generated_Image_9leagd9leagd9lea (1).png"
                    alt="Biblioteca"
                    className="absolute inset-0 w-full h-full object-cover"
                />

                <div className="absolute inset-0 bg-black/70" />

                <div className="absolute inset-0 bg-purple-900/50" />

                <div className="relative z-10 flex flex-col justify-start p-12 text-white pt-16 gap-8">

                    <div className="flex items-center gap-2">
                        <BookOpen size={40} />
                        <h1 className="text-3xl font-bold">
                            Books <span className="text-purple-400">On</span>
                        </h1>
                    </div>

                    <div>
                        <h2 className="text-5xl font-bold leading-tight mb-4 mt-15">
                            Bem-vindo de <span className="text-purple-400">volta!</span>
                        </h2>

                        <p className="text-lg text-gray-200 max-w-md pb-6">
                            Faça login para continuar sua jornada literária.
                        </p>

                        <div className="mt-10 space-y-6">

                            <div className="flex items-start gap-4">
                                <div className="bg-purple-600 p-3 rounded-full flex-shrink-0">
                                    <BookOpen size={20} />
                                </div>

                                <div>
                                    <h3 className="font-semibold text-lg">
                                        Milhares de livros
                                    </h3>

                                    <p className="text-gray-300">
                                        Encontre seus próximos favoritos.
                                    </p>
                                </div>
                            </div>

                            <div className="flex items-start gap-4">
                                <div className="bg-purple-600 p-3 rounded-full flex-shrink-0">
                                    <Tag size={20} />
                                </div>

                                <div>
                                    <h3 className="font-semibold text-lg">
                                        Ofertas exclusivas
                                    </h3>

                                    <p className="text-gray-300">
                                        Descontos imperdíveis para você.
                                    </p>
                                </div>
                            </div>

                            <div className="flex items-start gap-4">
                                <div className="bg-purple-600 p-3 rounded-full flex-shrink-0">
                                    <Heart size={20} />
                                </div>

                                <div>
                                    <h3 className="font-semibold text-lg">
                                        Sua estante
                                    </h3>

                                    <p className="text-gray-300">
                                        Organize seus livros preferidos.
                                    </p>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

            <div className="w-full lg:w-1/2 flex items-center justify-center p-6 md:p-8">
                <div
                    className="
                        bg-white
                        w-full
                        max-w-md
                        p-8
                        md:p-10
                        rounded-2xl
                        shadow-lg
                        border 
                        border-gray-200
                    "
                >
                    <h2
                        className="
                            text-2xl
                            md:text-3xl
                            font-bold
                            mb-2
                        "
                    >
                        {isLogin ? "Entrar" : "Criar Conta"}
                    </h2>
                    <p className="text-gray-500 mb-6">
                        {isLogin ? "Entre com sua conta" : "Crie sua nova conta"}
                    </p>

                    {/* Message Alert */}
                    {message && (
                        <div
                            className={`mb-6 p-4 rounded-lg flex items-center gap-3 ${
                                message.type === "success"
                                    ? "bg-green-50 border border-green-200"
                                    : "bg-red-50 border border-red-200"
                            }`}
                        >
                            {message.type === "success" ? (
                                <CheckCircle size={20} className="text-green-600 flex-shrink-0" />
                            ) : (
                                <AlertCircle size={20} className="text-red-600 flex-shrink-0" />
                            )}
                            <p
                                className={`text-sm ${
                                    message.type === "success" ? "text-green-800" : "text-red-800"
                                }`}
                            >
                                {message.text}
                            </p>
                        </div>
                    )}

                    {isLogin ? (
                        <form onSubmit={handleLogin} className="flex flex-col gap-5">
                            <div className="relative">
                                <Mail
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type="email"
                                    value={loginEmail}
                                    onChange={(e) => setLoginEmail(e.target.value)}
                                    placeholder="Digite seu email"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-4
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                            </div>

                            <div className="relative">
                                <Lock
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type={showPassword ? "text" : "password"}
                                    value={loginPassword}
                                    onChange={(e) => setLoginPassword(e.target.value)}
                                    placeholder="Digite sua senha"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-12
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                                <button
                                    type="button"
                                    onClick={() => setShowPassword(!showPassword)}
                                    disabled={loading}
                                >
                                    {showPassword ? (
                                        <EyeOff
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    ) : (
                                        <Eye
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    )}
                                </button>
                            </div>

                            <button
                                type="submit"
                                disabled={loading}
                                className="
                                    bg-purple-700
                                    text-white
                                    p-4
                                    rounded-xl
                                    font-bold
                                    hover:bg-purple-800
                                    transition
                                    disabled:bg-gray-400
                                    disabled:cursor-not-allowed
                                    flex
                                    items-center
                                    justify-center
                                    gap-2
                                "
                            >
                                {loading ? <Loader size={20} className="animate-spin" /> : null}
                                {loading ? "Entrando..." : "Entrar"}
                            </button>
                        </form>
                    ) : (
                        <form onSubmit={handleRegister} className="flex flex-col gap-5">
                            <div className="relative">
                                <User
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type="text"
                                    value={registerUsername}
                                    onChange={(e) => setRegisterUsername(e.target.value)}
                                    placeholder="Nome de usuário"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-4
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                            </div>

                            <div className="relative">
                                <Mail
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type="email"
                                    value={registerEmail}
                                    onChange={(e) => setRegisterEmail(e.target.value)}
                                    placeholder="Digite seu email"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-4
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                            </div>

                            <div className="relative">
                                <Lock
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type={showPassword ? "text" : "password"}
                                    value={registerPassword}
                                    onChange={(e) => setRegisterPassword(e.target.value)}
                                    placeholder="Digite sua senha"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-12
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                                <button
                                    type="button"
                                    onClick={() => setShowPassword(!showPassword)}
                                    disabled={loading}
                                >
                                    {showPassword ? (
                                        <EyeOff
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    ) : (
                                        <Eye
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    )}
                                </button>
                            </div>

                            <div className="relative">
                                <Lock
                                    size={18}
                                    className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400"
                                />
                                <input
                                    type={showConfirmPassword ? "text" : "password"}
                                    value={registerConfirmPassword}
                                    onChange={(e) => setRegisterConfirmPassword(e.target.value)}
                                    placeholder="Confirme sua senha"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    pl-12
                                    pr-12
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                                <button
                                    type="button"
                                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                    disabled={loading}
                                >
                                    {showConfirmPassword ? (
                                        <EyeOff
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    ) : (
                                        <Eye
                                            size={18}
                                            className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400 cursor-pointer"
                                        />
                                    )}
                                </button>
                            </div>

                            <div className="relative">
                                <input
                                    type="text"
                                    value={registerCpf}
                                    onChange={(e) => {
                                        let value = e.target.value.replace(/\D/g, "");
                                        if (value.length <= 11) {
                                            if (value.length > 5) {
                                                value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
                                            }
                                            setRegisterCpf(value);
                                        }
                                    }}
                                    placeholder="000.000.000-00"
                                    className="
                                    w-full
                                    border
                                    border-gray-400
                                    rounded-xl
                                    py-3
                                    px-4
                                    outline-none
                                    focus:border-purple-600
                                    disabled:bg-gray-100
                                    "
                                    disabled={loading}
                                />
                            </div>

                            <button
                                type="submit"
                                disabled={loading}
                                className="
                                    bg-purple-700
                                    text-white
                                    p-4
                                    rounded-xl
                                    font-bold
                                    hover:bg-purple-800
                                    transition
                                    disabled:bg-gray-400
                                    disabled:cursor-not-allowed
                                    flex
                                    items-center
                                    justify-center
                                    gap-2
                                "
                            >
                                {loading ? <Loader size={20} className="animate-spin" /> : null}
                                {loading ? "Criando conta..." : "Criar Conta"}
                            </button>
                        </form>
                    )}

                    <div className="mt-6 border-t border-gray-200 pt-6">
                        <p className="text-center text-gray-600 text-sm">
                            {isLogin ? "Não tem uma conta? " : "Já tem uma conta? "}
                            <button
                                onClick={() => {
                                    setIsLogin(!isLogin);
                                    setMessage(null);
                                }}
                                disabled={loading}
                                className="text-purple-700 font-bold hover:text-purple-800 transition disabled:text-gray-400"
                            >
                                {isLogin ? "Crie uma!" : "Entre aqui!"}
                            </button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Login