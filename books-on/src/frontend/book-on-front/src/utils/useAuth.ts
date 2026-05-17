import { useEffect, useState } from "react";
import { getToken, removeToken, isAuthenticated } from "../utils/authUtils";

export const useAuth = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [token, setToken] = useState<string | null>(null);

    useEffect(() => {
        const authToken = getToken();
        setToken(authToken);
        setIsLoggedIn(isAuthenticated());
    }, []);

    const logout = () => {
        removeToken();
        setIsLoggedIn(false);
        setToken(null);
        window.location.href = "/";
    };

    return {
        isLoggedIn,
        token,
        logout
    };
};
