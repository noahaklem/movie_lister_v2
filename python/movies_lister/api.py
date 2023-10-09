import setup

class API:

    def __init__(self):
        self.secret_key = setup.os.getenv("SECRET_KEY")
        self.base_url = "https://api.themoviedb.org/3/trending/movie/day?language=en-US"
        self.headers = {
            "Authorization": "Bearer {}".format(self.secret_key)
        }

    @classmethod
    def get_data(cls):
        api = cls()
        response = setup.requests.get(f"{api.base_url}", headers=api.headers)
        data = response.json()
        setup.movie_class.Movie.new_from_api(data['results'])
        