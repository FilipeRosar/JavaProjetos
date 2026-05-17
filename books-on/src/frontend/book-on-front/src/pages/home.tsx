import { useState, useEffect } from "react";
import { ChevronRight, Heart, BookMarked } from "lucide-react";
import Sidebar from "../components/Sidebar";
import Header from "../components/Header";
import BookCard from "../components/BookCard";
import { api } from "../services/api";

interface Book {
    id: number;
    title: string;
    author: string;
    imageUrl: string;
    rating: number;
}

interface Category {
    id: number;
    name: string;
    icon: React.ReactNode;
}

function Home() {
    const [userName, setUserName] = useState("Usuário");
    const [featuredBooks, setFeaturedBooks] = useState<Book[]>([]);
    const [continueReadingBook, setContinueReadingBook] = useState<Book | null>(null);
    const [shelfCount] = useState(12);
    const [favoritesCount] = useState(8);
    const [loadingBooks, setLoadingBooks] = useState(true);

    useEffect(() => {
        const storedUserName = localStorage.getItem("userName");
        if (storedUserName) {
            setUserName(storedUserName);
        }

        fetchHomeData();
    }, []);

    const fetchHomeData = async () => {
        try {
            setLoadingBooks(true);
            
            const booksResponse = await api.get("/v1/books");
            const books = booksResponse.data || [];
            
            if (books.length > 0) {
                setFeaturedBooks(books.slice(0, 5));
                if (books.length > 0) {
                    setContinueReadingBook(books[0]);
                }
            }
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        } catch (err: any) {
            console.error("Erro ao buscar livros:", err);
            setFeaturedBooks([]);
            
            const demoBooks: Book[] = [
                {
                    id: 1,
                    title: "É Assim que Acaba",
                    author: "Colleen Hoover",
                    imageUrl: "https://via.placeholder.com/220x340?text=É+Assim+que+Acaba",
                    rating: 4.8
                },
                {
                    id: 2,
                    title: "A Biblioteca da Meia-Noite",
                    author: "Matt Haig",
                    imageUrl: "https://via.placeholder.com/220x340?text=Biblioteca+da+Meia-Noite",
                    rating: 4.6
                },
                {
                    id: 3,
                    title: "O Poder da Ação",
                    author: "Paulo Vieira",
                    imageUrl: "https://via.placeholder.com/220x340?text=Poder+da+Ação",
                    rating: 4.7
                },
                {
                    id: 4,
                    title: "Hábitos Atômicos",
                    author: "James Clear",
                    imageUrl: "https://via.placeholder.com/220x340?text=Hábitos+Atômicos",
                    rating: 4.9
                },
                {
                    id: 5,
                    title: "1984",
                    author: "George Orwell",
                    imageUrl: "https://via.placeholder.com/220x340?text=1984",
                    rating: 4.7
                }
            ];
            
            setFeaturedBooks(demoBooks);
            setContinueReadingBook(demoBooks[0]);
        } finally {
            setLoadingBooks(false);
        }
    };

    const categories: Category[] = [
        { id: 1, name: "Ficção", icon: "📕" },
        { id: 2, name: "Romance", icon: "❤️" },
        { id: 3, name: "Desenvolvimento Pessoal", icon: "✨" },
        { id: 4, name: "Mistério e Suspense", icon: "🔍" },
        { id: 5, name: "Fantasia", icon: "🧚" }
    ];

    return (
        <div className="flex min-h-screen bg-gray-50">
            <Sidebar />
            <main className="flex-1">
                <Header />

                {/* Main Content */}
                <div className="p-8 max-w-7xl">
                    {/* Welcome Section */}
                    <div className="mb-12">
                        <h1 className="text-4xl font-bold text-gray-900">
                            Bem-vinda, {userName}! 👋
                        </h1>
                        <p className="text-gray-600 mt-2">
                            Que tal continuar sua jornada literária hoje?
                        </p>
                    </div>

                    {/* Featured Books Section */}
                    <section className="mb-16">
                        <div className="flex items-center justify-between mb-6">
                            <h2 className="text-2xl font-bold text-gray-900">
                                Destaques para você
                            </h2>
                            <button className="text-purple-600 font-semibold hover:text-purple-700 transition flex items-center gap-1">
                                Ver todos <ChevronRight size={18} />
                            </button>
                        </div>

                        {loadingBooks ? (
                            <div className="flex items-center justify-center py-12">
                                <p className="text-gray-500">Carregando livros...</p>
                            </div>
                        ) : (
                            <div className="flex gap-6 overflow-x-auto pb-4 -mx-4 px-4 scrollbar-hide">
                                {featuredBooks.map((book) => (
                                    <div key={book.id} className="flex-shrink-0">
                                        <BookCard
                                            title={book.title}
                                            author={book.author}
                                            image={book.imageUrl}
                                            rating={book.rating}
                                        />
                                    </div>
                                ))}
                            </div>
                        )}
                    </section>

                    {/* Continue Reading Section */}
                    <section className="mb-16">
                        <h2 className="text-2xl font-bold text-gray-900 mb-6">
                            Continue lendo
                        </h2>
                        {continueReadingBook ? (
                            <div className="bg-white rounded-2xl shadow-md p-8 border border-gray-200">
                                <div className="flex items-center gap-8">
                                    <img
                                        src={continueReadingBook.imageUrl}
                                        alt={continueReadingBook.title}
                                        className="w-32 h-48 object-cover rounded-xl shadow-lg"
                                    />
                                    <div className="flex-1">
                                        <h3 className="text-2xl font-bold text-gray-900 mb-2">
                                            {continueReadingBook.title}
                                        </h3>
                                        <p className="text-gray-600 mb-6">
                                            {continueReadingBook.author}
                                        </p>
                                        
                                        <div className="mb-6">
                                            <div className="flex items-center justify-between mb-2">
                                                <span className="text-sm font-semibold text-gray-700">
                                                    Progresso
                                                </span>
                                                <span className="text-sm text-gray-600">65%</span>
                                            </div>
                                            <div className="w-full bg-gray-200 rounded-full h-2">
                                                <div
                                                    className="bg-gradient-to-r from-purple-600 to-purple-700 h-2 rounded-full transition-all"
                                                    style={{ width: "65%" }}
                                                ></div>
                                            </div>
                                        </div>

                                        <button className="px-8 py-3 bg-gradient-to-r from-purple-600 to-purple-700 text-white rounded-xl font-semibold hover:shadow-lg transition">
                                            Continuar leitura
                                        </button>
                                    </div>
                                </div>
                            </div>
                        ) : (
                            <div className="bg-white rounded-2xl shadow-md p-8 border border-gray-200 text-center">
                                <p className="text-gray-500">Nenhum livro para continuar no momento</p>
                            </div>
                        )}
                    </section>

                    {/* Stats Section */}
                    <section className="mb-16">
                        <div className="grid grid-cols-2 gap-6">
                            <div className="bg-white rounded-2xl shadow-md p-8 border border-gray-200">
                                <div className="flex items-center justify-between">
                                    <div>
                                        <p className="text-gray-600 text-sm font-medium mb-1">
                                            Livros na estante
                                        </p>
                                        <p className="text-4xl font-bold text-purple-600">
                                            {shelfCount}
                                        </p>
                                        <button className="text-purple-600 text-sm font-semibold hover:text-purple-700 transition mt-3 flex items-center gap-1">
                                            Ver minha estante <ChevronRight size={16} />
                                        </button>
                                    </div>
                                    <BookMarked size={48} className="text-purple-200" />
                                </div>
                            </div>

                            <div className="bg-white rounded-2xl shadow-md p-8 border border-gray-200">
                                <div className="flex items-center justify-between">
                                    <div>
                                        <p className="text-gray-600 text-sm font-medium mb-1">
                                            Livros favoritos
                                        </p>
                                        <p className="text-4xl font-bold text-purple-600">
                                            {favoritesCount}
                                        </p>
                                        <button className="text-purple-600 text-sm font-semibold hover:text-purple-700 transition mt-3 flex items-center gap-1">
                                            Ver favoritos <ChevronRight size={16} />
                                        </button>
                                    </div>
                                    <Heart size={48} className="text-purple-200 fill-purple-200" />
                                </div>
                            </div>
                        </div>
                    </section>

                    {/* Categories Section */}
                    <section>
                        <div className="flex items-center justify-between mb-6">
                            <h2 className="text-2xl font-bold text-gray-900">
                                Categorias populares
                            </h2>
                            <button className="text-purple-600 font-semibold hover:text-purple-700 transition flex items-center gap-1">
                                Ver todas <ChevronRight size={18} />
                            </button>
                        </div>

                        <div className="grid grid-cols-5 gap-4">
                            {categories.map((category) => (
                                <button
                                    key={category.id}
                                    className="bg-white border-2 border-gray-200 rounded-2xl p-6 hover:border-purple-300 hover:shadow-md transition text-center group"
                                >
                                    <div className="text-4xl mb-3">{category.icon}</div>
                                    <p className="font-semibold text-gray-900 group-hover:text-purple-600 transition">
                                        {category.name}
                                    </p>
                                </button>
                            ))}
                        </div>
                    </section>
                </div>
            </main>
        </div>
    );
}

export default Home;