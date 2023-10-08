class API:

    def __init__(self):
        self.base_url = "https://api.themoviedb.org/3/trending/movie/day?language=en-US"
        self.auth = "Bearer #{ENV['SECRET_KEY']}"