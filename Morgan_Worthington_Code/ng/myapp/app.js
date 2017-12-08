const  express = require('express', '4.16.2')
const app = express()

app.get('/',(req,resp) => resp.send('Hello World!'))

app.listen(3000,() => console.log('listening to port 3000'))