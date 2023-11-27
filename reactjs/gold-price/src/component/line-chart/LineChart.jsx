import React from "react";
import './LineChart.css';
import { Line } from "react-chartjs-2";
import { Chart as ChartJS, registerables } from 'chart.js';
ChartJS.register(...registerables);

const LineChart = ({ dataLine1, nameLine1, dataLine2, nameLine2, labelsX }) => {
  const chartData = {
    labels: labelsX,
    datasets: [
      {
        label: nameLine1,
        fill: false,
        lineTension: 0.1,
        backgroundColor: 'rgba(255, 223, 0, 0.4)', // yellow color for background
        borderColor: 'rgba(255, 0, 0, 1)', // Red color for Line 1
        pointBackgroundColor: '#fff',
        pointBorderColor: 'rgba(255, 0, 0, 1)',
        data: dataLine1,
      },
      {
        label: nameLine2,
        fill: false,
        lineTension: 0.1,
        backgroundColor: 'rgba(0, 0, 0, 0.4)', // Black color for Line 2
        borderColor: 'rgba(0, 0, 0, 1)', // Black color for Line 2
        pointBackgroundColor: '#fff',
        pointBorderColor: 'rgba(0, 0, 0, 1)',
        data: dataLine2,
      },
    ],
  };

  const chartOptions = {
    scales: {
      x: {
        ticks: {
          color: 'white', // White text for the X-axis
        },
      },
      y: {
        ticks: {
          color: 'white', // White text for the Y-axis
        },
      },
    },plugins: {
      legend: {
        display: false, // Hide Legend
      },
    },
  };

  return (
    <div>
      <h3>
        Domestic Gold Chart  (TP.HCM)
      </h3>
      <div className="d-flex justify-content-between">
        <span>Unit Of Measurement 1 = 1000 VND </span>
        <span>22/11/2023, 17:23</span>
      </div>
      <div className="chartBody d-flex">
        <div>
          <Line data={chartData} options={chartOptions} />
        </div>
      </div>
    </div>
    
  );
};

export default LineChart;
