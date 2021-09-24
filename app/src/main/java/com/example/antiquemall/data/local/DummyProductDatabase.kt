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
                dimension = "Width : 23 cm | Height : 30 cm | Depth : 23 cm",
                seller = Seller(
                    name = "Cassidy Valdez",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/10.jpg",
                    phone = "0112502 981 2792",
                    city = "Duleek",
                    latitude = 22.8543,
                    longitude = 152.8797
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
                dimension = "Width : 33 cm | Height : 40 cm | Depth : 33 cm",
                seller = Seller(
                    name = "Sheryl Cole",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/83.jpg",
                    phone = "0112502 981 271",
                    city = "Nottingham",
                    latitude = -73.9919,
                    longitude = -43.3259
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
                dimension = "Width : 23 cm | Height : 30 cm | Depth : 23 cm",
                seller = Seller(
                    name = "Samuel Rantanen",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/men/10.jpg",
                    phone = "02-417-621",
                    city = "Keminmaa",
                    latitude = -85.4590,
                    longitude = 130.2531
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
                dimension = "Width : 19 cm | Height : 50 cm | Depth : 19 cm",
                seller = Seller(
                    name = "Lorraine Taylor",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/38.jpg",
                    phone = "06-3291-7712",
                    city = "Albury",
                    latitude = 49.3564,
                    longitude = 179.9250
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
                dimension = "Width : 14 cm | Height : 16 cm | Depth : 14 cm",
                seller = Seller(
                    name = "Deborah Dean",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/66.jpg",
                    phone = "016973 05872",
                    city = "Ely",
                    latitude = 38.4534,
                    longitude = 116.0578
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
                dimension = "Width : 27 cm | Height : 29 cm | Depth : 10 cm",
                seller = Seller(
                    name = "Alani da Mata",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/75.jpg",
                    phone = "(48) 6464-7307",
                    city = "Uruguaiana",
                    latitude = -6.9669,
                    longitude = 104.0041
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
                dimension = "Width : 16 cm | Height : 19 cm | Depth : 16 cm",
                seller = Seller(
                    name = "Flora Lecomte",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/women/28.jpg",
                    phone = "03-44-49-81-67",
                    city = "Creteil",
                    latitude = 26.6245,
                    longitude = 6.4312
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
                dimension = "Width : 12 cm | Height : 35 cm | Depth : 16 cm",
                seller = Seller(
                    name = "Traugott Rmeoml",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/men/93.jpg",
                    phone = "0079-6218623",
                    city = "Lugau",
                    latitude = 64.0155,
                    longitude = -64.2013
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
                dimension = "Width : 9 cm | Height : 16 cm | Depth : 9 cm",
                seller = Seller(
                    name = "Rayn Ray",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/men/62.jpg",
                    phone = "013873 49055",
                    city = "Inverness",
                    latitude = -80.6331,
                    longitude = -35.9123
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
                dimension = "Width : 6 cm | Height : 10 cm | Depth : 6 cm",
                seller = Seller(
                    name = "Barış Egeli",
                    photoUrl = "https://randomuser.me/api/portraits/thumb/men/42.jpg",
                    phone = "(237)-546-9438",
                    city = "İstanbul",
                    latitude = 41.015137,
                    longitude = 28.979530
                )
            )

        )
    }


    fun getAllProducts() = products

    fun getProductsById(id: Int) = products.find { it.id == id }

    fun getFavoritesProducts() = products.filter { it.isFavorite }

    fun setProductFavoriteStatus(id: Int, isFavorite: Boolean) {
        getProductsById(id)?.isFavorite = isFavorite
    }


    fun refreshAllProducts() {
        products.forEach {
            it.isFavorite = false
        }
    }
}