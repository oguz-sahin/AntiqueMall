package com.example.antiquemall.data.local

import com.example.antiquemall.data.model.Product
import com.example.antiquemall.data.model.Seller

/**
 * Created by Oguz Sahin on 9/14/2021.
 */
object DummyProductDatabase {

    private val products by lazy {
        arrayListOf(
            Product(
                id = 1,
                name = "Hand Painted Ceramic Vase",
                color = "Blue and White",
                material = "Ceramic",
                status = "Like New",
                price = 7640.15,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/cff14503-9821-4656-b065-2bb561291e84.jpeg",
                    "https://cdn.dekopasaj.com/products/3/8d8ca6ba-2902-4dc0-ae36-d3fa3c6097bc.jpeg",
                    "https://cdn.dekopasaj.com/products/3/cff14503-9821-4656-b065-2bb561291e84.jpeg"
                ),
                dimension = "23cm X 30cm X 23cm",
                seller = Seller(
                    name = "Cassidy Valdez",
                    photoUrl = "https://static.generated.photos/vue-static/face-generator/landing/wall/20.jpg",
                    phone = "0112502 981 2792",
                    city = "Duleek",
                    latitude = 53.655800,
                    longitude = -6.415730
                )
            ),
            Product(
                id = 2,
                name = "Hand Painted Ceramic Red Vase",
                color = "Red and White",
                material = "Ceramic",
                status = "Like New",
                price = 10390.20,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/9bb9105e-29fa-4046-8a2e-c063ba1cfe87.jpeg",
                    "https://cdn.dekopasaj.com/products/3/9bb9105e-29fa-4046-8a2e-c063ba1cfe87.jpeg",
                    "https://cdn.dekopasaj.com/products/3/9bb9105e-29fa-4046-8a2e-c063ba1cfe87.jpeg"
                ),
                dimension = "33cm X 40cm X 33cm",
                seller = Seller(
                    name = "Sheryl Cole",
                    photoUrl = "https://images.generated.photos/O4GYE3E3YkRXNPw9VnSQ2-jfYCZJpaEkOVmHv3LY8vA/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MjUwMzQyLmpwZw.jpg",
                    phone = "0112502 981 271",
                    city = "Nottingham",
                    latitude = 54.110943,
                    longitude = 4.886719
                )
            ),
            Product(
                id = 3,
                name = "Ceramic Vase Green Color Hand Painting",
                color = "Green,White,Red",
                material = "Ceramic",
                status = "Like New",
                price = 7334.15,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/cff14503-9821-4656-b065-2bb561291e84.jpeg",
                    "https://cdn.dekopasaj.com/products/3/dcf67ce1-e4de-4bc8-9cbd-06eaba8a0d0b.jpeg",
                    "https://cdn.dekopasaj.com/products/3/ddcdd683-afff-4e9f-86de-0866bc6cca97.jpeg"
                ),
                dimension = "23cm X 30cm X 23cm",
                seller = Seller(
                    name = "Samuel Rantanen",
                    photoUrl = "https://images.generated.photos/Z5ABdMujarcTAS1mUfngfvo4HzWUcfXfAQ_FQZqq9DU/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MDA3MDIwLmpwZw.jpg",
                    phone = "02-417-621",
                    city = "Keminmaa",
                    latitude = 65.801270,
                    longitude = 24.545019
                )
            ),
            Product(
                id = 4,
                name = "Polyester Peacock Vase",
                color = "Colorful",
                material = "Polyester",
                status = "Like New",
                price = 22456.45,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/9e6fa320-47e7-4021-a0e0-b9206361a940.jpeg",
                    "https://cdn.dekopasaj.com/products/3/2ed5a680-c09d-4200-954f-73d1330881d3.jpeg",
                    "https://cdn.dekopasaj.com/products/1/f5c7f57c-95ed-4240-b8d0-91423fc5e348.jpeg"
                ),
                dimension = "19cm X 50cm X 19cm",
                seller = Seller(
                    name = "Lorraine Taylor",
                    photoUrl = "https://images.generated.photos/guMaZBboDP63nfnYZrz3E4NgmuI5CXQHu_23VwvnPCI/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/Mjk4OTQ2LmpwZw.jpg",
                    phone = "06-3291-7712",
                    city = "Albury",
                    latitude = -36.073730,
                    longitude = 146.913544
                )
            ),
            Product(
                id = 5,
                name = "Vase In Two Hands",
                color = "Gold",
                material = "Other",
                status = "Like New",
                price = 128665.00,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/d8a14a3d-b037-4db2-a68e-99baf51d194a.png"
                ),
                dimension = "14cm X 16cm X 14cm",
                seller = Seller(
                    name = "Deborah Dean",
                    photoUrl = "https://images.generated.photos/EnVQyx45wAwp60VmyfNSxo4F-78RYkqfz0Z82nEwzpw/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MDg0OTUyLmpwZw.jpg",
                    phone = "016973 05872",
                    city = "Ely",
                    latitude = 52.399448,
                    longitude = 0.259790
                )
            ),
            Product(
                id = 6,
                name = "Polyester Coral Vase",
                color = "Red",
                material = "Other",
                status = "Like New",
                price = 120345.15,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/3eda175b-6062-44ec-8c32-c9683e622727.jpeg",
                    "https://cdn.dekopasaj.com/products/3/24bd5e94-0f44-454c-8869-de557e453a9d.jpeg",
                    "https://cdn.dekopasaj.com/products/3/6dc02e07-dc6b-4b22-a1a0-3f40cb4b9d15.jpeg"
                ),
                dimension = "27cm X 29cm X 10cm",
                seller = Seller(
                    name = "Alani da Mata",
                    photoUrl = "https://images.generated.photos/1a69ALkmzhMLl0z899KFzQhBlutpoWsiSbaoO_jJKjo/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MzU1OTg3LmpwZw.jpg",
                    phone = "(48) 6464-7307",
                    city = "Uruguaiana",
                    latitude = -29.758459,
                    longitude = -57.096020
                )
            ),
            Product(
                id = 7,
                name = "Hand Figured Vase",
                color = "Red",
                material = "Other",
                status = "Like New",
                price = 25000.15,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/d8f68d4a-836b-4950-bee3-a03b5122d125.png"
                ),
                dimension = "16cm X 19cm X 16cm",
                seller = Seller(
                    name = "Flora Lecomte",
                    photoUrl = "https://images.generated.photos/_Jv3OTCuwV-3cI6qDn2HOjH_oyGBzanpoEIg3HJZNNI/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/NjY4NTAyLmpwZw.jpg",
                    phone = "03-44-49-81-67",
                    city = "Creteil",
                    latitude = 48.789612,
                    longitude = 2.452600
                )
            ),
            Product(
                id = 8,
                name = "Double Snake Vase",
                color = "Gold",
                material = "Other",
                status = "Like New",
                price = 120000.00,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/ae3a4ca4-c433-46b3-b91e-4e8694a2768f.png"
                ),
                dimension = "12cm X 35cm X 16cm",
                seller = Seller(
                    name = "Traugott Rmeoml",
                    photoUrl = "https://images.generated.photos/EiZbGG0T3jQioSsUVLzFBEkCHyLy_BeNsX6mJmHtI2I/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/NjYyMDM3LmpwZw.jpg",
                    phone = "0079-6218623",
                    city = "Lugau",
                    latitude = 50.739010,
                    longitude = 12.734580
                )
            ),
            Product(
                id = 9,
                name = "Ceramic Face Vase",
                color = "Black and White",
                material = "Ceramic",
                status = "Like New",
                price = 140000.00,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/eb0127d6-2d87-4d06-be56-1d4e6a23623a.jpeg",
                    "https://cdn.dekopasaj.com/products/3/81b085c2-91a7-4b38-9e7a-eb4da3298a7b.jpeg"
                ),
                dimension = "9cm X 16cm X 9cm",
                seller = Seller(
                    name = "Rayn Ray",
                    photoUrl = "https://images.generated.photos/SHi3Ny0yc4vj9Cwox2B3gsGwa4Y4iTTSQ0pJOJGWYMk/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/NzAyNDU0LmpwZw.jpg",
                    phone = "013873 49055",
                    city = "Inverness",
                    latitude = 57.477772,
                    longitude = -4.224721
                )
            ),
            Product(
                id = 10,
                name = "Enameled Enamel Vase On Bronze",
                color = "Colorful",
                material = "Other",
                status = "Used",
                price = 145000.00,
                photoUrls = listOf(
                    "https://cdn.dekopasaj.com/products/3/26a57c09-1d12-44cc-b98e-630da4c14f2f.jpeg",
                    "https://cdn.dekopasaj.com/products/3/63070ca7-a86b-40f7-938c-34545e39b1d1.jpeg",
                    "https://cdn.dekopasaj.com/products/3/6fb7ad7c-d281-4c0b-831a-9112f16fc9cb.jpeg"
                ),
                dimension = "6cm X 10cm X 6cm",
                seller = Seller(
                    name = "Barış Egeli",
                    photoUrl = "https://images.generated.photos/fLFyGEX9yyVJrZEJyf_7n23TYfvCts49wkg4pUPc0W8/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/Nzk3Mjk4LmpwZw.jpg",
                    phone = "(237)-546-9438",
                    city = "İstanbul",
                    latitude = 41.015137,
                    longitude = 28.979530
                )
            )

        )
    }


    fun getAllProducts() = products

    fun getProductById(id: Int) = products.find { it.id == id }

    fun getFavoritesProducts() = products.filter { it.isFavorite }

    fun setProductFavoriteStatus(id: Int, isFavorite: Boolean, completeListener: () -> Unit) {
        getProductById(id)?.isFavorite = isFavorite
        completeListener.invoke()
    }


    fun refreshAllProducts() {
        products.forEach {
            it.isFavorite = false
        }
    }
}