# NOTES

## FLOW
    1. The user opens the app and is greeted in the CLI
    2. Asks the user for some type of input. (very simple)
        EX: Would you like to get a list of the most popular movies across all streaming sites now?
    3. If yes, then the app will provide a list of popular movies across all streaming networks
    Optional 4. User can select a movie and get the details (where to watch, quick description, rating, etc)

## CLASSES
    1. API - providing data for movie class
        1a. will need to communicate with api somehow = HTTParty or URI & net/http

            # response = HTTParty.get(@base_url, headers: {
            #     Authorization: @auth
            # } )

            results are stored in a 'results' array 
                attributes are: 
                    "original_title"
                    "overview"
                    "release_date"
                    "vote_average"

        1b. will need to organize data for movie class
            doesnt need to organize the data due to structure of array of objects
    <div>
        <img src="./flowchart.png" alt="flowchart picture">
    </div>
    2. Movie - creating movie instances
         2a. create and save new movies from api
         2b. pass those movies to CLI for presentation

    3. CLI - Responsible for user interaction and presentation
        3a. Greets user
        3b. Asks for user input
        3c. Ends program when finished
    
## QUESTIONS
    Questions:
        1. Is there any class relationships?

