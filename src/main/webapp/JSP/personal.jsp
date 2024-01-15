<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../INC/meta.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous" defer></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.css" integrity="sha512-KOWhIs2d8WrPgR4lTaFgxI35LLOp5PRki/DxQvb7mlP29YZ5iJ5v8tiLWF7JLk5nDBlgPP1gHzw96cZ77oD7zQ==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link rel="stylesheet" href="${context}CSS/logInStyles.css"/>
        <title>Tec-Shop</title>
    </head>
    <body>
        <form action="${context}Register" method="post">
            <button type="submit" class="back"><i class="fa-solid fa-arrow-left" style="color: #dedfde;"></i></button>
            <img src="${context}IMG/Logo.png" class="logo">
            <div class="container">
                <div class="row justify-content-end">
                    <div class="col-6">
                        <h1 class="text-center title">Crear cuenta</h1>
                        <div class="accordion" id="accordionExample">
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingOne">
                                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        Datos de la cuenta
                                    </button>
                                </h2>
                                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <label for="email" class="form-label">Email:</label>
                                        <input type="text" name="email" id="email" class="form-control" value="${user.email}">
                                        <label for="password" class="form-label mt-3">Contraseña:</label>
                                        <input type="text" name="password" id="pasword" class="form-control" value="${user.password}">
                                        <label for="repPassword" class="form-label mt-3">Repetir contraseña:</label>
                                        <input type="text" name="repPassword" id="repPassword" class="form-control" value="${user.password}">
                                        <label for="avatar" class="form-label mt-3">Avatar:</label>
                                        <input type="file" name="avatar" id="avatar" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingTwo">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Datos personales
                                    </button>
                                </h2>
                                <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <label for="nombre" class="form-label">Nombre:</label>
                                        <input type="text" name="nombre" id="nombre" class="form-control" value="${user.nombre}">
                                        <label for="apellidos" class="form-label mt-3">Apellidos:</label>
                                        <input type="text" name="apellidos" id="apellidos" class="form-control" value="${user.apellidos}">
                                        <label for="nif" class="form-label mt-3">NIF:</label>
                                        <input type="text" name="nif" id="nif" class="form-control" value="${user.nif}">
                                        <label for="telefono" class="form-label mt-3">Teléfono:</label>
                                        <input type="text" name="telefono" id="telefono" class="form-control" value="${user.telefono}">
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingThree">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        Dirección
                                    </button>
                                </h2>
                                <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <label for="direccion" class="form-label">Dirección:</label>
                                        <input type="text" name="direccion" id="direccion" class="form-control" value="${user.direccion}">
                                        <label for="codigoPostal" class="form-label mt-3">Código postal:</label>
                                        <input type="text" name="codigoPostal" id="codigoPostal" class="form-control" value="${user.codigoPostal}">
                                        <label for="localidad" class="form-label mt-3">Localidad:</label>
                                        <input type="text" name="localidad" id="localidad" class="form-control" value="${user.localidad}">
                                        <label for="provincia" class="form-label mt-3">Provincia:</label>
                                        <input type="text" name="provincia" id="provincia" class="form-control" value="${user.provincia}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <input type="submit" name="cerrar" class="btn btn-danger mt-3 me-3" value="Cerrar Sesión">
                            <input type="submit" name="crear" class="btn btn-primary mt-3" value="Modificar">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>