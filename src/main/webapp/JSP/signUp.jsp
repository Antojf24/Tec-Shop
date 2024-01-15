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
        <form action="${context}SignUp" method="post">
            <button type="submit" class="back"><i class="fa-solid fa-arrow-left" style="color: #dedfde;"></i></button>
            <img src="${context}IMG/Logo.png" class="logo">
            <div class="container w-50">
                <div class="row justify-content-end">
                    <div class="col-6">
                        <h1 class="text-center title">Crear cuenta</h1>
                        <div class="background rounded-3 p-4">
                            <span style="color:red;">${message}</span>
                            <label for="email" class="form-label text-white">Email:</label>
                            <input type="text" name="email" id="email" class="form-control">
                            <label for="password" class="form-label text-white">Contraseña:</label>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <div class="d-flex justify-content-end">
                            <input type="submit" name="crear" class="btn btn-primary mt-3" value="Iniciar Sesión">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>