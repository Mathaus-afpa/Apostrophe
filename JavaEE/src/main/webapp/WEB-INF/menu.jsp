<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sidebar flex-col fixed top-0 bottom-0 left-0 mr-3 mt-3 mb-3 p-2 w-64 overflow-y-auto bg-slate-50 rounded-r-xl shadow-lg shadow-gray-500">
    <!-- Affichage du rôle de l'utilisateur -->
    <div class="flex flex-col items-center">
        <c:choose>
            <c:when test="${not empty requestScope.role}">
                <span class="text-center text-red-500">${requestScope.role}</span>
            </c:when>
            <c:otherwise>
                <span class="text-center text-red-500">Visiteur</span>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${not empty requestScope.utilisateur}">
                <span class="text-center text-red-500">${requestScope.utilisateur}</span>
            </c:when>
            <c:otherwise>
                <span class="text-center text-red-500">?</span>
            </c:otherwise>
        </c:choose>
        <!-- Logo -->
        <svg class="w-48" xmlns="http://www.w3.org/2000/svg" version="1.0" width="190.000000pt" height="180.000000pt"
             viewBox="0 0 190.000000 180.000000" preserveAspectRatio="xMidYMid meet">
            <g transform="translate(0.000000,180.000000) scale(0.100000,-0.100000)" fill="#000000" stroke="none">
                <path d="M1305 1545 c-89 -39 -101 -42 -112 -28 -7 9 -14 21 -16 26 -5 17 -763 -307 -758 -324 2 -8 6 -21 8 -31 3 -10 -3 -19 -18 -23 -13 -4 -52 -20 -87 -36 l-63 -29 26 -34 26 -35 -43 -19 c-24 -10 -80 -34 -125 -52 -45 -18 -80 -37 -77 -41 2 -5 28 -21 56 -36 l51 -28 -47 -20 -47 -20 288 -119 c159 -65 293 -123 298 -129 7 -6 2 -7 -13 -2 -16 4 -49 -4 -103 -25 -43 -18 -79 -34 -79 -35 0 -2 15 -13 34 -25 32 -19 34 -24 29 -57 -5 -32 -4 -36 13 -31 10 3 255 105 543 227 288 121 529 221 537 221 7 0 17 -7 22 -16 8 -14 11 -14 26 7 25 37 20 76 -14 111 -27 27 -36 30 -74 26 l-42 -5 83 226 c46 124 92 250 103 278 l19 53 -37 -16 c-47 -20 -82 -34 -86 -34 -2 0 3 26 10 57 7 31 12 59 10 61 -2 1 -47 -15 -101 -37 -54 -23 -101 -41 -106 -41 -5 0 -9 18 -9 40 0 26 -4 40 -12 39 -7 -1 -58 -20 -113 -44z m97 -207 l15 -183 2 127 c0 70 5 137 10 150 6 17 29 32 77 51 37 15 70 25 72 23 2 -3 -5 -47 -17 -98 -40 -183 -90 -414 -96 -451 -6 -28 -13 -39 -32 -43 -15 -4 -22 -12 -19 -20 3 -8 4 -14 3 -14 -2 0 -138 56 -302 124 l-299 124 -80 -35 c-45 -19 -177 -75 -294 -124 -210 -88 -213 -89 -243 -73 -17 8 -28 18 -25 22 4 3 151 67 329 142 l322 137 165 -85 c91 -47 161 -80 155 -75 -13 13 -314 193 -323 193 -4 0 -108 -43 -231 -95 -207 -87 -225 -93 -237 -77 -7 9 -14 19 -14 22 0 3 147 68 328 144 l327 138 60 -68 c33 -38 77 -86 98 -109 36 -37 35 -36 -11 30 -27 39 -66 96 -87 128 -21 31 -43 57 -49 57 -6 0 -123 -47 -260 -105 -136 -58 -252 -105 -258 -105 -30 0 9 27 87 60 50 21 198 84 329 139 132 56 243 98 247 94 4 -4 33 -66 64 -136 32 -70 59 -126 61 -124 2 2 -13 54 -32 116 -19 62 -34 114 -32 115 11 8 155 65 164 66 7 0 16 -64 26 -182z"/>
            </g>
        </svg>
    </div>
    <!-- Menu principal -->
    <!-- /Accueil -->
    <a class="group" href="/Accueil">
        <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
            <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="currentColor">
                <path d="M240-200h120v-240h240v240h120v-360L480-740 240-560v360Zm-80 80v-480l320-240 320 240v480H520v-240h-80v240H160Zm320-350Z"/>
            </svg>
            <span class="pt-1 text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Accueil</span>
        </div>
    </a>
    <!-- /Livres -->
    <a class="group" href="/Livres">
        <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
            <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="currentColor">
                <path d="M480-160q-48-38-104-59t-116-21q-42 0-82.5 11T100-198q-21 11-40.5-1T40-234v-482q0-11 5.5-21T62-752q46-24 96-36t102-12q58 0 113.5 15T480-740v484q51-32 107-48t113-16q36 0 70.5 6t69.5 18v-480q15 5 29.5 10.5T898-752q11 5 16.5 15t5.5 21v482q0 23-19.5 35t-40.5 1q-37-20-77.5-31T700-240q-60 0-116 21t-104 59Zm80-200v-380l200-200v400L560-360Zm-160 65v-396q-33-14-68.5-21.5T260-720q-37 0-72 7t-68 21v397q35-13 69.5-19t70.5-6q36 0 70.5 6t69.5 19Zm0 0v-396 396Z"/>
            </svg>
            <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Livres</span>
        </div>
    </a>
    <!-- /Connexion -->
    <c:choose>
        <c:when test="${not empty requestScope.utilisateur}">
            <a class="group" href="/Deconnexion">
                <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
                    <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="currentColor">
                        <path d="M480-440q-58 0-99-41t-41-99q0-58 41-99t99-41q58 0 99 41t41 99q0 58-41 99t-99 41Zm0-80q25 0 42.5-17.5T540-580q0-25-17.5-42.5T480-640q-25 0-42.5 17.5T420-580q0 25 17.5 42.5T480-520Zm0 460L120-280v-400l360-220 360 220v400L480-60Zm0-93 147-91q-34-18-71.5-27t-75.5-9q-38 0-75.5 9T333-244l147 91ZM256-291q50-34 107-51.5T480-360q60 0 117 17.5T704-291l56-33v-311L480-806 200-635v311l56 33Zm224-189Z"/>
                    </svg>
                    <span class="text-red-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Deconnexion</span>
                </div>
            </a>
        </c:when>
        <c:otherwise>
            <a class="group" href="/Connexion">
                <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
                    <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="currentColor">
                        <path d="M480-440q-58 0-99-41t-41-99q0-58 41-99t99-41q58 0 99 41t41 99q0 58-41 99t-99 41Zm0-80q25 0 42.5-17.5T540-580q0-25-17.5-42.5T480-640q-25 0-42.5 17.5T420-580q0 25 17.5 42.5T480-520Zm0 460L120-280v-400l360-220 360 220v400L480-60Zm0-93 147-91q-34-18-71.5-27t-75.5-9q-38 0-75.5 9T333-244l147 91ZM256-291q50-34 107-51.5T480-360q60 0 117 17.5T704-291l56-33v-311L480-806 200-635v311l56 33Zm224-189Z"/>
                    </svg>
                    <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">S'identifier</span>
                </div>
            </a>
        </c:otherwise>
    </c:choose>

    <!-- /CGU -->
    <a class="group" href="/CGU">
        <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
            <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="currentColor" stroke="currentColor">
                <path d="M480-80q-139-35-229.5-159.5T160-516v-244l320-120 320 120v244q0 85-29 163.5T688-214L560-342q-18 11-38.5 16.5T480-320q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 22-5.5 42.5T618-398l60 60q20-41 31-86t11-92v-189l-240-90-240 90v189q0 121 68 220t172 132q26-8 49.5-20.5T576-214l56 56q-33 27-71.5 47T480-80Zm0-320q33 0 56.5-23.5T560-480q0-33-23.5-56.5T480-560q-33 0-56.5 23.5T400-480q0 33 23.5 56.5T480-400Zm8-77Z"/>
            </svg>
            <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">CGU</span>
        </div>
    </a>

    <c:choose>
        <c:when test="${requestScope.role == 'administrateur'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role}</h3>
            <a class="group" href="/Administrateur">
                <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
                    <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="currentColor" stroke="currentColor">
                        <path d="M480-80q-139-35-229.5-159.5T160-516v-244l320-120 320 120v244q0 85-29 163.5T688-214L560-342q-18 11-38.5 16.5T480-320q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 22-5.5 42.5T618-398l60 60q20-41 31-86t11-92v-189l-240-90-240 90v189q0 121 68 220t172 132q26-8 49.5-20.5T576-214l56 56q-33 27-71.5 47T480-80Zm0-320q33 0 56.5-23.5T560-480q0-33-23.5-56.5T480-560q-33 0-56.5 23.5T400-480q0 33 23.5 56.5T480-400Zm8-77Z"/>
                    </svg>
                    <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Gestion</span>
                </div>
            </a>
        </c:when>
        <c:when test="${requestScope.role == 'libraire'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role}</h3>
            <a class="group" href="/Libraire">
                <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
                    <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="currentColor" stroke="currentColor">
                        <path d="M480-80q-139-35-229.5-159.5T160-516v-244l320-120 320 120v244q0 85-29 163.5T688-214L560-342q-18 11-38.5 16.5T480-320q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 22-5.5 42.5T618-398l60 60q20-41 31-86t11-92v-189l-240-90-240 90v189q0 121 68 220t172 132q26-8 49.5-20.5T576-214l56 56q-33 27-71.5 47T480-80Zm0-320q33 0 56.5-23.5T560-480q0-33-23.5-56.5T480-560q-33 0-56.5 23.5T400-480q0 33 23.5 56.5T480-400Zm8-77Z"/>
                    </svg>
                    <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Gestion</span>
                </div>
            </a>
        </c:when>
        <c:when test="${requestScope.role == 'client'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role}</h3>
            <a class="group" href="/Client">
                <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
                    <svg class="w-8 text-gray-700 group-hover:text-lime-300" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="currentColor" stroke="currentColor">
                        <path d="M480-80q-139-35-229.5-159.5T160-516v-244l320-120 320 120v244q0 85-29 163.5T688-214L560-342q-18 11-38.5 16.5T480-320q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 22-5.5 42.5T618-398l60 60q20-41 31-86t11-92v-189l-240-90-240 90v189q0 121 68 220t172 132q26-8 49.5-20.5T576-214l56 56q-33 27-71.5 47T480-80Zm0-320q33 0 56.5-23.5T560-480q0-33-23.5-56.5T480-560q-33 0-56.5 23.5T400-480q0 33 23.5 56.5T480-400Zm8-77Z"/>
                    </svg>
                    <span class="text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">Emprunts</span>
                </div>
            </a>
        </c:when>
    </c:choose>
</div>
<div class="content flex-col justify-items-center pl-60">
    <c:if test="${not empty page}">
        <jsp:include page="${page}" />
    </c:if>
</div>