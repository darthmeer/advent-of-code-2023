#!/usr/bin/groovy

def lines = []
def digits, first, last, lastSize, combined

new File('input.txt').eachLine { line ->
  digits = line.findAll(/\d+/)*.toInteger()
  first = digits.first().toString().substring(0, 1)
  lastSize = digits.last().toString().size()
  last = digits.last().toString().substring(lastSize-1, lastSize)
  combined = (first + last).toInteger()
  lines.add(combined)
}

println(lines.sum())
