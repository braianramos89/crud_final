<div class="modal fade" id="agregarLibroModal" tabindex="-1" aria-labelledby="agregarLibroModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="producto">Producto</label>
                        <input type="text" class="form-control" name="producto" required="">
                    </div>
                    <div class="form-group">
                        <label for="autor">Marca</label>
                        <input type="text" class="form-control" name="marca">
                    </div>
                    <div class="form-group">
                        <label for="cantPaginas">Vida Util</label>
                        <input type="number" class="form-control" name="vidaUtil" required="">
                    </div>
                    <div class="form-group">
                        <label for="precio">Valor</label>
                        <input type="currency" class="form-control" name="precio" required="">
                    </div>
                    <div class="form-group">
                        <label for="copias">Cantidad</label>
                        <input type="number" class="form-control" name="copias" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
