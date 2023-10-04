class MovieLister::API 
    Dotenv.load
    
    def initialize
        @base_url = "https://api.themoviedb.org/3/trending/movie/day?language=en-US"
        @auth = "Bearer #{ENV['SECRET_KEY']}"
    end

    def get_data
        response = HTTParty.get(@base_url, headers: {
            Authorization: @auth
        } )
        MovieLister::Movie.new_from_api(response['results'])
    end


end