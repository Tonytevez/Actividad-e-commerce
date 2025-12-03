import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

fun main() {
    val client = OkHttpClient()
    val url = "https://jsonkeeper.com/b/MX0A"

    val request = Request.Builder().url(url).build()
    val response = client.newCall(request).execute()

    val json = response.body?.string()
    if (json != null) {
        val root = JSONObject(json)
        val products = root.getJSONArray("products")

        for (i in 0 until products.length()) {
            val item = products.getJSONObject(i)
            val name = item.getString("name")
            val price = item.getDouble("price")

            println("Nombre: $name  | Precio: $price")
        }
    }
}
