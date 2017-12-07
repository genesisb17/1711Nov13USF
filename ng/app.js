const express = require("express","3.10.10")
const app = express()
app.get('/',(req,res)=>res.send('Hello World!!'))
app.listen(3000,()=>console.log('listening to port 3000'))

