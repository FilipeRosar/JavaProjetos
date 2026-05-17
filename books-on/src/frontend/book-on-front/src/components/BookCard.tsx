
type BookCardProps = {
    title: string;
    author: string;
    image: string;
    rating: number;
};
function BookCard({ title, author, image, rating }: BookCardProps) {
    return (
        <div className="min-w-[220px] bg-white border border-gray-200 rounded-2xl overflow-hidden hover:shadow-lg transition">
            <img src={image} alt={`${title} cover`} className="w-full h-80 object-cover" />
            <div className="p-4">
                <h3 className="text-lg font-semibold text-gray-900">{title}</h3>
                <p className="text-gray-500 mt-1">{author}</p>
                <div className="mt-3 flex items-center gap-1">
                    <span className="text-yellow-500">★</span>
                    <span className="text-gray-700">{rating.toFixed(1)}</span>
                </div>
            </div>
        </div>
    );
}
export default BookCard;