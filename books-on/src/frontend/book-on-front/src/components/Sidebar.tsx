import {
    House,
    Compass,
    Library,
    Heart,
    Grid2X2,
    Tag,
} from "lucide-react";

function Sidebar() {
    return (
        <aside className="w-72 bg-gradient-to-b from-purple-950 to-purple-900 text-white min-h-screen p-6">
            <div className="flex items-center gap-3 mb-8">
               <div className="w-10 h-10 bg-purple-500 rounded-x1"></div>
               <h1 className="text-3x1 font-bold">
                Books <span className="text-purple-400">On</span>
               </h1>
            </div>

            <nav className="mt-12 flex flex-col gap-4">
                <button className="flex items-center gap-4 bg-purple-700 p-4 rounded-2x1">
                    <House size={22} />
                    <span>Início</span>
                </button>
                <button className="flex items-center gap-4 p-4 hover:bg-purple-800 rounded-2x1 transition-colors">
                    <Compass size={22} />
                    <span>Explorar</span>
                </button>
                <button className="flex items-center gap-4 p-4 hover:bg-purple-800 rounded-2x1 transition-colors">
                    <Library size={22} />
                    <span>Minha Estante</span>
                </button>
                <button className="flex items-center gap-4 p-4 hover:bg-purple-800 rounded-2x1 transition-colors">
                    <Heart size={22} />
                    <span>Favoritos</span>
                </button>
                <button className="flex items-center gap-4 p-4 hover:bg-purple-800 rounded-2x1 transition-colors">
                    <Grid2X2 size={22} />
                    <span>Categorias</span>
                </button>
                <button className="flex items-center gap-4 p-4 hover:bg-purple-800 rounded-2x1 transition-colors">
                    <Tag size={22} />
                    <span>Promoções</span>
                </button>
            </nav>
        </aside>
    )
}
export default Sidebar;