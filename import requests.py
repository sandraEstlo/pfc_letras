import requests

# URL base de la API de Google Books
base_url = "https://www.googleapis.com/books/v1/volumes"

# Parámetros de búsqueda para obtener los primeros resultados (máximo permitido por la API)
params = {
    "maxResults": 40  # Cambia el número de resultados según tus necesidades
}

# Conjunto para almacenar todas las categorías y subcategorías
all_categories = set()

# Realizar la solicitud GET inicial para obtener los primeros resultados
response = requests.get(base_url, params=params)

# Verificar el estado de la respuesta
if response.status_code == 200:
    # Si la solicitud fue exitosa, obtener el contenido JSON de la respuesta
    data = response.json()
    
    # Procesar los resultados obtenidos
    for item in data.get("items", []):
        volume_info = item.get("volumeInfo", {})
        categories = volume_info.get("categories", [])
        all_categories.update(categories)

    # Iterar sobre las siguientes páginas de resultados, si las hay
    while "nextPageToken" in data:
        next_page_token = data["nextPageToken"]
        params["pageToken"] = next_page_token
        
        # Realizar la solicitud GET para la siguiente página de resultados
        response = requests.get(base_url, params=params)
        
        # Verificar el estado de la respuesta
        if response.status_code == 200:
            # Si la solicitud fue exitosa, obtener el contenido JSON de la respuesta
            data = response.json()
            
            # Procesar los resultados obtenidos
            for item in data.get("items", []):
                volume_info = item.get("volumeInfo", {})
                categories = volume_info.get("categories", [])
                all_categories.update(categories)
        else:
            # Si la solicitud no fue exitosa, mostrar el mensaje de error
            print("Error:", response.status_code)
            print(response.text)
            break

# Imprimir todas las categorías y subcategorías
for category in all_categories:
    print(category)




