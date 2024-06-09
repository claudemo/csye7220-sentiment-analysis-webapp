import axios from 'axios';
import React, { useState } from 'react';

function SentimentAnalyzer() {
    const [sentence, setSentence] = useState('');
    const [result, setResult] = useState(null);

    const handleInputChange = (e) => {
        setSentence(e.target.value);
    };

    const analyzeSentiment = () => {
        axios.post('http://localhost:8080/testSentiment', { sentence })
            .then(response => {
                setResult(response.data);
            })
            .catch(error => console.error('Error:', error));
    };

    const getResultStyle = () => {
        if (!result) return {};
        const polarity = result.polarity;
        if (polarity > 0.1) return { color: 'green' };
        if (polarity < -0.1) return { color: 'red' };
        return { color: 'blue' };
    };

    return (
        <div>
            <h1>Sentiment Analyzer</h1>
            <input
                type="text"
                value={sentence}
                onChange={handleInputChange}
                placeholder="Enter a sentence"
            />
            <button onClick={analyzeSentiment}>Analyze Sentiment</button>
            {result && (
                <p style={getResultStyle()}>
                    Sentence: {result.sentence} <br />
                    Polarity: {result.polarity}
                </p>
            )}
        </div>
    );
}

export default SentimentAnalyzer;
