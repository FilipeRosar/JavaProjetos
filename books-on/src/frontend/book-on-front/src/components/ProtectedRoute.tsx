import { Navigate } from "react-router-dom";
import { isAuthenticated } from "../utils/authUtils";

interface ProtectedRouteProps {
    children: React.ReactNode;
}

function ProtectedRoute({ children }: ProtectedRouteProps) {
    if (!isAuthenticated()) {
        return <Navigate to="/" replace />;
    }

    return <>{children}</>;
}

export default ProtectedRoute;
