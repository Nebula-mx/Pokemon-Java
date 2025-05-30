i=1
for f in frame_*.jpg; do
  mv "$f" "Bg$i.jpg"
  ((i++))
done