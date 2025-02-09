import React, { useEffect, useRef } from 'react';
import './Gallery.css';

// Import images
import halloween from './images/img1.jpg';
import GD from './images/img2.jpg';
import Air from './images/img3.jpg';
import Handi from './images/img4.jpg';
import Campus from './images/img5.jpg';
import soft from './images/img6.jpg';
import Lab from './images/img7.jpg';
import Picnic from './images/img8.jpg';
import lab from './images/img9.jpg';
import soft1 from './images/img10.jpg';
import Navbar from '../Navbar/Navbar';
import Footer from '../Footer/Footer';

const Gallery = () => {
    const carouselRef = useRef(null);
    const listRef = useRef(null);
    const runningTimeRef = useRef(null);
    const timeRunning = 3000;
    const timeAutoNext = 7000;
    let runTimeOut;
    let runNextAuto;

    useEffect(() => {
        const nextBtn = carouselRef.current.querySelector('.next');
        const prevBtn = carouselRef.current.querySelector('.prev');
        const list = listRef.current;
        const runningTime = runningTimeRef.current;

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
            runningTime.offsetHeight; /* trigger reflow */
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

    return (
        <>
        
              <Navbar/>
            <header>
                <nav>
                    <a href="/" className="active">Some Recent Events at Vita</a>
                </nav>
              
            </header>

            <div className="carousel" ref={carouselRef}>
                <div className="list" ref={listRef}>
                    <div className="item" style={{ backgroundImage: `url(${halloween})` }}>
                        <div className="content">
                            <div className="title">Halloween</div>
                            <div className="name">Celebration</div>
                            <div className="des">Halloween is a spooky celebration with costumes, candy, haunted houses, pumpkins, trick-or-treating, ghosts, witches, parties, horror movies, and fun scares! 🎃👻</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${GD})` }}>
                        <div className="content">
                            <div className="title">Group </div>
                            <div className="name">Disccusion</div>
                            <div className="des">Group discussions encourage teamwork, communication, leadership, critical thinking, and idea-sharing.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${Air})` }}>
                        <div className="content">
                            <div className="title">Fresh</div>
                            <div className="name">Air Code</div>
                            <div className="des">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Officiis culpa similique consequuntur, reprehenderit dicta repudiandae.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${Handi})` }}>
                        <div className="content">
                            <div className="title">DahiHandi</div>
                            <div className="name">Celebration</div>
                            <div className="des">Dahi Handi is a vibrant festival celebrating Krishna's birth with teamwork, enthusiasm, pyramids, devotion, joy, energy, excitement, tradition, culture, unity, spirit, competition, fun, challenge, determination, strength, balance, celebration, festivity, and victory.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${Campus})` }}>
                        <div className="content">
                            <div className="title">Campus</div>
                            <div className="name">Whooom</div>
                            <div className="des">Campus life is vibrant, educational, social, dynamic, engaging, diverse, inspiring, challenging, fun, interactive, memorable, inclusive, innovative, cultural, exploratory, academic, and transformative.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${soft})` }}>
                        <div className="content">
                            <div className="title">Soft</div>
                            <div className="name">Skill</div>
                            <div className="des">Communication, teamwork, adaptability, problem-solving, leadership, empathy, creativity and accountability.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${Lab})` }}>
                        <div className="content">
                            <div className="title">Labs</div>
                            <div className="name">Exp</div>
                            <div className="des">Experiments, research, innovation, equipment, safety, chemistry, biology, physics, technology, testing, discovery, analysis, precision, data, observation, scientists, engineering.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${Picnic})` }}>
                        <div className="content">
                            <div className="title">Lohgad</div>
                            <div className="name">Picnic</div>
                            <div className="des">Outdoor, nature, fun, food, friends, family, games, laughter, relaxation, sunshine, adventure, bonding, enjoyment, music, memories..</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${lab})` }}>
                        <div className="content">
                            <div className="title">SLIDER</div>
                            <div className="name">HERON</div>
                            <div className="des">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Officiis culpa similique consequuntur, reprehenderit dicta repudiandae.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${soft})` }}>
                        <div className="content">
                            <div className="title">Soft</div>
                            <div className="name">Skills</div>
                            <div className="des">Gentle, smooth, calm, warm, delicate, fluffy, tender, light, cozy, kind, soothing, subtle, graceful, quiet, peaceful.</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>

                    <div className="item" style={{ backgroundImage: `url(${soft1})` }}>
                        <div className="content">
                            <div className="title">Soft</div>
                            <div className="name">Skills</div>
                            <div className="des">Gentle, smooth, calm, warm, delicate, fluffy, tender, light, cozy, kind, soothing, subtle, graceful, quiet, peaceful..</div>
                            <div className="btn">
                                <button>See More</button>
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="arrows">
                    <button className="prev">&lt;</button>
                    <button className="next">&gt;</button>
                </div>

                <div className="timeRunning" ref={runningTimeRef}></div>
            </div>

            <Footer/>
        </>
    );
};

export default Gallery;