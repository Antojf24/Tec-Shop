<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../INC/meta.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous" defer></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.css" integrity="sha512-KOWhIs2d8WrPgR4lTaFgxI35LLOp5PRki/DxQvb7mlP29YZ5iJ5v8tiLWF7JLk5nDBlgPP1gHzw96cZ77oD7zQ==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link rel="stylesheet" href="${styles}"/>
        <title>Tec-Shop</title>
    </head>
    <body>
        <form action="${context}FrontController" method="post">
            <nav
                class="navbar navbar-expand-sm navbar-light p-0"
                >
                <div class="container">
                    <div class="space">
                        <img src="./IMG/Logo.png" alt="Logo" class="logo">
                    </div>
                    <button
                        class="navbar-toggler d-lg-none"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapsibleNavId"
                        aria-controls="collapsibleNavId"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavId">
                        <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                            <li class="nav-item">
                                <input type="submit" class="nav-link active text-white" value="Inicio" name="option"/>
                            </li>
                            <li class="nav-item">
                                <input type="submit" class="nav-link active text-white" value="Tienda" name="option" aria-current="page"/>
                            </li>
                            <li class="nav-item">
                                <input type="submit" class="nav-link text-white" value="Info" name="option"/>
                            </li>
                        </ul>
                        <div class="d-flex ">
                            <div class="search">
                                <input
                                    class="form-control me-sm-2"
                                    type="text"
                                    placeholder="Ej. Placas base"
                                    />
                                <input
                                    class="btn btn-outline-light my-2 my-sm-0"
                                    type="submit"
                                    value="Buscar"
                                    name="option"
                                    >
                            </div>
                            <div class="sesion d-flex p-0">
                                <c:choose>
                                    <c:when test="${idUser != null}">
                                        <p class="text-white">${name}</p>
                                        <input 
                                            type="submit"
                                            class="btn my-2 my-sm-0 text-white"
                                            value="Area Personal"
                                            name="option"
                                            >
                                    </c:when>
                                    <c:otherwise>
                                        <input 
                                            type="submit"
                                            class="btn my-2 my-sm-0 text-white"
                                            value="Iniciar Sesion"
                                            name="option"
                                            >
                                        <input 
                                            type="submit"
                                            class="btn my-2 my-sm-0 login text-white"
                                            value="Registrarse"
                                            name="option"
                                            >
                                    </c:otherwise>  
                                </c:choose>
                                <input 
                                    class="btn my-2 my-sm-0 login text-white"
                                    value="Carrito"
                                    name="option"
                                    >
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </form>
        <div class="container">
            <h2 class="text-white mt-3">Todos los productos</h2>
            <div class="row d-flex justify-content-center">
                <c:forEach var="product" items="${products}">
                    <div class="card col-12 col-md-3 m-3">
                        <img class="card-img-top productImg" src="IMG/images/productos/${product.imagen}.jpg" alt="${product.nombre}"/>
                        <div class="card-body">
                            <h4 class="card-title">${product.nombre}</h4>
                            <p class="card-text">${product.descripcion}</p>
                            <p>Precio: <fmt:formatNumber type="currency" value="${product.precio}"/></p>
                            <label for="cantidad">Cantidad:</label>
                            <div class="d-flex">
                                <input type="number" class="form-control" name="cantidad" id="cantidad" step="1" min="0" value="0">
                                <input class="btn btn-primary" name="comprar" value="Comprar">
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
