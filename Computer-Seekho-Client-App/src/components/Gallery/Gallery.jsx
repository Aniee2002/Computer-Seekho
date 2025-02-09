import React, { useEffect, useState, useRef } from 'react';
import Navbar from '../Navbar/Navbar';
import Footer from '../Footer/Footer';
import './Gallery.css';

const Gallery = () => {
    const [albums, setAlbums] = useState([]); // Store fetched data
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState(null);

    const carouselRef = useRef(null);
    const listRef = useRef(null);
    const runningTimeRef = useRef(null);
    const timeRunning = 3000;
    const timeAutoNext = 7000;
    let runTimeOut;
    let runNextAuto;

    // ✅ Fetch data from API (Replaces Redux)
    useEffect(() => {
        fetch('http://localhost:8080/image/all')
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Failed to fetch albums');
                }
                return response.json();
            })
            .then((data) => {
                setAlbums(data);
                console.log(data);
                setIsLoading(false);
            })
            .catch((error) => {
                setError(error.message);
                setIsLoading(false);
            });
    }, []);

    // **DO NOT CHANGE ANIMATION LOGIC**
    useEffect(() => {
        const nextBtn = carouselRef.current?.querySelector('.next');
        const prevBtn = carouselRef.current?.querySelector('.prev');
        const list = listRef.current;
        const runningTime = runningTimeRef.current;

        if (!nextBtn || !prevBtn || !list || !runningTime) return;

        const showSlider = (type) => {
            const sliderItemsDom = list.querySelectorAll('.item');
            if (type === 'next') {
                list.appendChild(sliderItemsDom[0]);
                carouselRef.current.classList.add('next');
            } else {
                list.prepend(sliderItemsDom[sliderItemsDom.length - 1]);
                carouselRef.current.classList.add('prev');
            }
            clearTimeout(runTimeOut);

            runTimeOut = setTimeout(() => {
                carouselRef.current.classList.remove('next');
                carouselRef.current.classList.remove('prev');
            }, timeRunning);

            clearTimeout(runNextAuto);
            runNextAuto = setTimeout(() => {
                nextBtn.click();
            }, timeAutoNext);

            resetTimeAnimation();
        };

        const resetTimeAnimation = () => {
            runningTime.style.animation = 'none';
            runningTime.offsetHeight; // trigger reflow
            runningTime.style.animation = null;
            runningTime.style.animation = 'runningTime 7s linear 1 forwards';
        };

        nextBtn.onclick = () => showSlider('next');
        prevBtn.onclick = () => showSlider('prev');

        runNextAuto = setTimeout(() => {
            nextBtn.click();
        }, timeAutoNext);

        return () => {
            clearTimeout(runNextAuto);
            clearTimeout(runTimeOut);
        };
    }, []);

    if (isLoading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <>
            <Navbar />
            <header>
                <nav>
                    <a href="/" className="active">Some Recent Events at Vita</a>
                </nav>
            </header>

            <div className="carousel" ref={carouselRef}>
                <div className="list" ref={listRef}>
                    {albums.map((album, index) => (
                        <div
                            key={album.image_id || index}
                            className="item"
                            style={{ backgroundImage: `url(${album.image_url})` }}
                        >
                            <div className="content">
                                <div className="title">{album.image_title}</div>
                                <div className="des">{album.image_description}</div>
                                <div className="btn">
                                    <button>See More</button>
                                    <button>Subscribe</button>
                                </div>
                            </div>
                        </div>
                    ))}

                </div>

                <div className="arrows">
                    <button className="prev">&lt;</button>
                    <button className="next">&gt;</button>
                </div>

                <div className="timeRunning" ref={runningTimeRef}></div>
            </div>

            <Footer />
        </>
    );
};

export default Gallery;
