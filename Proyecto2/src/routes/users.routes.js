import { Router } from "express";
import cookieParser from 'cookie-parser';
import { getAllUsers ,cerrar2,vistal,cerrarSesion, modificac,contra, login,index,admin,Operativo,registra,registrarUsuario,borrauser,Tokenauth,Tokenautho,cargar,carrito,info,correos,Tokenauthc,cambia,editar,updateuserp,updateusera, updateuserq, updateusere,updateusern} from "../controllers/users.controllers.js"
const router = Router();


updateuserp,updateusera, updateuserq, updateusere,updateusern
router.post("/registrar", Tokenauth,registrarUsuario);
router.post("/login", login);
router.get('/eliminar', Tokenauth,borrauser);
router.get("/editar",Tokenauth,editar);
router.get("/vistal",Tokenauth,vistal);
router.get("/cargar",Tokenautho,cargar);
router.get("/carrito",Tokenautho,carrito);
router.post("/infoc",Tokenautho,info);
router.post("/correos",correos);
router.post("/cambia",Tokenauthc,cambia);
router.get('/restablecer-contrasena/:token',contra);
router.post("/modifica",modificac);
router.get('/cerrar', cerrarSesion);
router.get('/cerrar2', cerrar2);

router.post("/updateuserp",Tokenauth,updateuserp);
router.post("/updateusera",Tokenauth,updateusera);
router.post("/updateuserq",Tokenauth,updateuserq);
router.post("/updateusere",Tokenauth,updateusere);
router.post("/updateusern",Tokenauth,updateusern);

//VISTAS
router.get("/index",index);
router.get("/admin",Tokenauth,admin);
router.get("/Operativo",Tokenauth,Operativo);
router.get("/registra",Tokenauth,registra);


export default router;

