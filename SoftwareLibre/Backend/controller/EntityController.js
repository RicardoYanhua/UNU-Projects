const db = require("../config/DataConnection");

const Listar = async (req, res) => {
  const SQL_TABLE_NAME = "";
  const SQL_TABLE_PK = "";
  try {
    const [DB_LISTA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " ORDER BY " + SQL_TABLE_PK + " DESC"
    );
    res.json({
      success: true,
      count: DB_LISTA.length,
      data: DB_LISTA,
    });
  } catch (error) {
    res.json({
      success: false,
      mensaje: "Error al obtener los registros.",
      error: error.message,
    });
  }
};

const ObtenerPorId = async (req, res) => {
  const SQL_TABLE_NAME = "";
  const SQL_TABLE_PK = "";
  try {
    const { id } = req.params;
    const [DB_LISTA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (DB_LISTA.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    res.json({
      success: true,
      mensaje: "Registro Encontrado.",
      data: DB_LISTA[0],
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al obtener el registro.",
      error: error.message,
    });
  }
};

const Crear = async (req, res) => {
  const SQL_TABLE_NAME = "";
  try {
    //JSON
    const { 
        var1, 
        var2, 
        var3
        } 
        = req.body;
    // VALIDACIONES
    if (!var1 || !var2 || !var3) {
      return res.status(400).json({
        success: true,
        mensaje: "Campos obligatorios, no puede estar vacio.",
      });
    }
    // CREACION DEL REGISTRO
    const [CREATED] = await db.query(
      " INSERT INTO " +
        SQL_TABLE_NAME +
        " ( " +
        " var1, " +
        " var2, " +
        " var3  " +
        " ) " +
        " VALUES (?,?,?) ",
      [var1, var2, var3]
    );
    res.status(201).json({
      success: true,
      mensaje: "Se ha creado un nuevo registro exitosamente.",
      data: {
        id: CREATED.insertId,
        var1,
        var2,
        var3
      },
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al crear el registro.",
      error: error.message,
    });
  }
};

const Actualizar = async (req, res) => {
  const SQL_TABLE_NAME = "";
  const SQL_TABLE_PK = "";
  try {
    const { id } = req.params;
    const { 
        var1, 
        var2, 
        var3
        } 
        = req.body;
    // VERIFICAMOS SI EXISTE
    const [EXIST] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (EXIST.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    // ACTUALIZAMOS REGISTRO
    await db.query(
      " UPDATE " +
        SQL_TABLE_NAME +
        " SET " +
        " var1 = ?, " +
        " var2 = ?, " +
        " var3 = ?  " +
        " WHERE " + SQL_TABLE_PK + " = ?",
      [var1, var2, var3, id]
    );
    res.status(201).json({
      success: true,
      mensaje: "Registro actualizado exitosamente.",
      data: {
        id,
        var1,
        var2,
        var3
      },
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al actualizar el registro.",
      error: error.message,
    });
  }
};

const Eliminar = async (req, res) => {
  const SQL_TABLE_NAME = "";
  const SQL_TABLE_PK = "";
  try {
    const { id } = req.params;
    // VERIFICAMOS SI EXISTE
    const [EXIST] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (EXIST.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    // ELIMINAMOS EL REGISTRO
    await db.query("DELETE FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?", [id]);
    res.status(201).json({
      success: true,
      mensaje: "Se ha eliminado el registro correctamente.",
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al eliminar el registro.",
      error: error.message,
    });
  }
};

const Buscar = async (req, res) => {
  const SQL_TABLE_NAME = "";
  const SQL_TABLE_PK = "";
  const SQL_TABLE_VAR_SEARCH = "";
  try {
    const { buscar } = req.query;
    if (!buscar) {
      return res.status(400).json({
        success: false,
        mensaje: "Debe proporcionar un texto para realizar la búsqueda.",
      });
    }
    const [BUSQUEDA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_VAR_SEARCH + " LIKE ? ORDER BY " + SQL_TABLE_PK + " DESC ",
      ["%" + buscar + "%"]
    );
    if (BUSQUEDA.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje:
          "No se encontraron registros con el texto de busqueda insertado.",
      });
    }
    res.json({
      success: true,
      mensaje: "Búsqueda realizada correctamente.",
      count: BUSQUEDA.length,
      data: BUSQUEDA
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al realizar la búsqueda.",
      error: error.message,
    });
  }
};

// CONSULTAR INNER JOIN (EXAMPLES)
/*
const ListarPedidosPorRestaurante = async (req, res) => {
    const DB_TABLE_1 = 'pedidos';
    const DB_TABLE_2 = 'meseros';
    const DB_TABLE_3 = 'restaurantes';
    try {

        const { id } = req.params;
        const [DB_RESULT] = await db.query(

             'SELECT p.codigo AS id_pedido, p.fecha, p.hora, p.total, r.nombre AS restaurante, m.nombres AS mesero'
            + ' FROM ' + DB_TABLE_1 + ' AS p'
            + ' INNER JOIN ' + DB_TABLE_2 + ' m ON p.id_mesero = m.codigo'
            + ' INNER JOIN ' + DB_TABLE_3 + ' r ON m.id_restaurante = r.codigo'
            + ' WHERE r.codigo = ?',
            [id]
        );
        res.json({
            success: true,
            mensaje: 'Lista de pedidos segun el restaurante',
            count: DB_RESULT.length,
            data: DB_RESULT
        });

    } catch (error) {
        console.error(error);
        res.status(500).json({
            success: false,
            mensaje: 'Error al obtener los datos',
            error: error.message
        });
    }
};

const ListarPedidosPorCategoriaPlato = async (req, res) => {
    const DB_TABLE_1 = 'pedidos';
    const DB_TABLE_2 = 'detalle_pedido';
    const DB_TABLE_3 = 'platos';
    const DB_TABLE_4 = 'categorias';
    try {

        const { id } = req.params;

        const [DB_RESULT] = await db.query(

             'SELECT p.codigo, p.fecha, p.hora, p.total, t.nombre AS platos, c.nombre AS categorias'
            + ' FROM ' + DB_TABLE_1 + ' AS p'
            + ' INNER JOIN ' + DB_TABLE_2 + ' d ON p.codigo = d.id_pedido'
            + ' INNER JOIN ' + DB_TABLE_3 + ' t ON d.id_plato = t.codigo'
            + ' INNER JOIN ' + DB_TABLE_4 + ' c ON t.id_categoria = c.codigo'
            + ' WHERE c.codigo = ?',
            [id]
        );
        res.json({
            success: true,
            mensaje: 'Lista de pedidos segun la categoria de plato',
            count: DB_RESULT.length,
            data: DB_RESULT
        });

    } catch (error) {
        console.error(error);
        res.status(500).json({
            success: false,
            mensaje: 'Error al obtener los datos',
            error: error.message
        });
    }
};

*/

module.exports = {
    Listar,
    Crear,
    Eliminar,
    Actualizar,
    Buscar,
    ObtenerPorId
};
