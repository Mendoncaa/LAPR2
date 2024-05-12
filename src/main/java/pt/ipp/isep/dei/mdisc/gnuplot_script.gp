# Script Gnuplot para gerar o gráfico
set datafile separator ';'
set terminal pngcairo enhanced font "arial,10" fontscale 1.0 size 800, 600
set output "30Files_ExecutionTimes_plot.png"
set xlabel "Data Set Size"
set ylabel "Execution Time (ns)"
set title "Execution Time vs. Data Set Size"
plot "30Files_ExecutionTimes.csv" with lines