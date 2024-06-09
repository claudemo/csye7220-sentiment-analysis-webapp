### testing very locally

http://127.0.0.1:5000/testHealth
http://localhost:3000/?webapp=http://localhost:8080

python endpoint
http://127.0.0.1:5000/analyse?sentence=i+am+so+down

### start java backend
cd sa-webapp/target

java -jar sentiment-analysis-web-0.0.1-SNAPSHOT.jar --sa.logic.api.url=http://localhost:5000

http://localhost:8080/testHealth
### frontend
cd sentiment-analysis-frontend/src
npm start


curl --location --request POST 'http://localhost:8080/testSentiment' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sentence": "I am very happy today!"
}'

http://localhost:3001/?webapp=http://localhost:8080

testing to access from 8080 java endpoint
this won't work
http://localhost:8080/testSentiment/analyse?sentence=i+am+so+down
