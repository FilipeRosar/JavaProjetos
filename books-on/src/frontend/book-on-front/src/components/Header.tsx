import {
    Bell,
    Moon,
    Search,
    LogOut
} from "lucide-react";
import { useAuth } from "../utils/useAuth";
import { useState } from "react";

function Header(){
    const { logout } = useAuth();
    const [showLogoutMenu, setShowLogoutMenu] = useState(false);

    return(
        <header className="flex items-center justify-between py-4 px-8 bg-white border-b border-gray-200">
            <div className="relative w-full max-w-2xl">
                <Search size={20} className="absolute left-4 top-1/2 -translate-y-1/2 text-gray-400" />
                <input type="text"
                 placeholder="Busque por livros, autores ou categorias..."
                 className="w-full border border-gray-300 rounded-2xl py-3 pl-12 pr-4 outline-none focus:ring-2 focus:ring-purple-600 text-gray-900"
                />
            </div>
             <div className="flex items-center gap-6 ml-6">

                <button className="text-gray-600 hover:text-gray-900 transition">
                    <Bell size={20} />
                </button>

                <button className="text-gray-600 hover:text-gray-900 transition">
                    <Moon size={20} />
                </button>

                <div className="relative">
                    <button
                        onClick={() => setShowLogoutMenu(!showLogoutMenu)}
                        className="w-10 h-10 rounded-full overflow-hidden hover:ring-2 hover:ring-purple-600 transition"
                    >
                        <img
                            src="https://i.pravatar.cc/150"
                            alt="User Avatar"
                            className="w-full h-full object-cover"
                        />
                    </button>
                    
                    {showLogoutMenu && (
                        <div className="absolute right-0 mt-2 w-48 bg-white rounded-xl shadow-lg border border-gray-200 z-50">
                            <button
                                onClick={logout}
                                className="w-full flex items-center gap-3 px-4 py-3 text-red-600 hover:bg-red-50 rounded-xl transition"
                            >
                                <LogOut size={18} />
                                <span className="font-semibold">Sair</span>
                            </button>
                        </div>
                    )}
                </div>
            </div>
        </header>
    )
}

export default Header;