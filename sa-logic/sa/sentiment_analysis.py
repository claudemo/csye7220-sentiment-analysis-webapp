from textblob import TextBlob
from flask import Flask, request, jsonify
import requests
app = Flask(__name__)

@app.route("/testHealth")
def hello():
    return "Hello from python sentiment analysis flask app!"
 
@app.route("/analyse/sentiment", methods=['POST'])
def analyse_sentiment():
    sentence = request.get_json()['sentence']
    polarity = TextBlob(sentence).sentences[0].polarity
    return jsonify(
        sentence=sentence,
        polarity=polarity
    )

@app.route("/analyse", methods=['GET'])
def analyse_sentiment_get():
    sentence = request.args.get('sentence') #query parameter
    polarity = TextBlob(sentence).sentences[0].polarity
    return str(polarity)

@app.route('/testComms', methods=['GET'])
def fetch_external_api():
    try:
        # URL of the external API
        external_url = "http://localhost:8080/testHealth"
        # Make the GET request to the external API
        response = requests.get(external_url)
        # Check if the request was successful
        if response.status_code == 200:
            # Return the response content from the external API
            return jsonify(message=response.text), 200
        else:
            # Return an error message if the request was not successful
            return jsonify(error="Failed to retrieve data from external API",
                           status_code=response.status_code), response.status_code
    except requests.exceptions.RequestException as e:
        # Handle any exceptions that occur during the request
        return jsonify(error=str(e)), 500













if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)