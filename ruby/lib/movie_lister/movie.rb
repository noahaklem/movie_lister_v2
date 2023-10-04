class MovieLister::Movie 

    attr_reader :original_title, :overview, :release_date, :vote_average

    @@all = []

    def initialize(original_title:, overview:, release_date:, vote_average:)
        @original_title = original_title
        @overview = overview
        @release_date = release_date
        @vote_average = vote_average
        save
    end

    def self.all
        @@all
    end

    def save 
        self.class.all << self
    end

    def self.new_from_api(data)
        data.each do |movie|
            new(
                original_title: movie['original_title'],
                overview: movie['overview'],
                release_date: movie['release_date'],
                vote_average: movie['vote_average']
            )
        end
        MovieLister::CLI.show(all)
    end
end