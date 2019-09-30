module.exports = {
    publicPath:'/',
    assetsDir: "",
    outputDir: "../src/main/resources/static",
    indexPath: "../templates/index.html",
    devServer:{
        proxy:'http://localhost:8080'
    }
};