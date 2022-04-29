<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Raf Hakaton</title>
    <%@include file="styles.jsp"%>

</head>
<body>
<!-- Header Start -->
<header class="position-fixed w-100">
    <div class="container">
        <nav class="navbar navbar-expand-md navbar-light">
            <a class="navbar-brand" style="padding: 0" href="index.jsp"><img style="max-width: 155px" src="https://hakaton.raf.edu.rs/assets/images/Hakaton_logo.png" alt="RAF Hakaton"></a>
            <div class="group d-flex align-items-center">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Početna</a></li>
                    <li class="nav-item"><a class="nav-link" href="#oTakmicenju">O takmičenju</a></li>
                    <li class="nav-item"><a class="nav-link" href="#nagrade">Nagrade</a></li>
                    <li class="nav-item"><a class="nav-link" href="#partneri">Partneri</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<!-- Header End -->

<canvas id="c" height="937" width="2560"></canvas>

<section class="hero" id="pocetna" style="min-height:100vh;">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="swiper-container hero-slider text-center">
                    <div class="swiper-wrapper d-flex justify-content-center">
                        <div class=" slide-content d-flex align-items-center">
                            <div class="single-slide">
                                <h1 class="underlined mb-3 text-uppercase">Da li možeš da osvojiš RAF?
                                </h1>
                                <h2 class="sub-heading mb-3">RAF Hakaton, 28. April.</h2>
                                <button style=" display: inline-block;
                                    line-height: 50px;
                                    padding: 0 50px;
                                    cursor: pointer;
                                    font-size: 25px;
                                    text-transform: uppercase;
                                    font-weight: 700;
                                    color: #fff;
                                    font-family: inherit;" class="btn btn--radius-2 btn--red" type="button" onclick = "location.href= 'teamApplication.jsp'">Prijavi se</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Add Control -->


<div class="texture"></div>
<div class="diag-bg"></div>

<section class="services" id="oTakmicenju">
    <div class="container">
        <div class="title text-center">
            <h6>Ukratko</h6>
            <h1 class="title-blue">O takmičenju</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-lg-4">
                    <div class="media">
                        <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/calendar.png" alt="Vreme">
                        <div class="media-body">
                            <h5>Vreme</h5>
                            Takmičenje će početi u subotu, 21. decembra, o tačnoj
                            satnici takmičari će biti naknadno obavešteni.
                            Hakaton traje 24 sata od trenutka prezentovanja teme.
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <div class="media">
                        <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/lokacija.png" alt="Mesto">
                        <div class="media-body">
                            <h5>Mesto</h5>
                            Hakaton će se održati na Računarskom fakultetetu. Fakultet se nalazi u samom
                            centru Beograda, u Knez Mihailovoj 6/VI. Svakom timu će biti dodeljena posebna učionica za rad.
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <div class="media">
                        <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/idea.png" alt="Tema">
                        <div class="media-body">
                            <h5>Tema</h5>
                            Tema će biti poznata na dan takmičenja. Tada će timovi dobiti sve neophodne informacije
                            i biće upoznati sa zadatkom. Tačno 12 sati nakon početka, svim takmičarima biće predstavljen
                            još jedan zahtev koji bi trebalo da ispune.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Services End -->
<section class="pricing-table" id="nagrade">
    <div class="container">
        <div class="title text-center">
            <h1 class="title-blue">Nagrade</h1>
        </div>
        <div class="row no-gutters">
            <div class="col-md-4 order-2 order-md-1 reward-custom-padding">
                <div class="single-pricing text-center second-place">
                    <span>2.</span>
                    <h2 class="mb-3">Drugo mesto</h2>
                    <img src="https://hakaton.raf.edu.rs/assets/images/crypto/ethereum_cricle.png" alt="Ethereum" class="img-fluid crypto-img">
                    <p class="price mt-3" style="line-height:0.8em;">50 000</p>
                    <p class="currency " style="line-height:0.8em;">dinara</p>
                    <p style="font-size:1.3em;" class="mt-5">U Ethereum kriptovaluti</p>
                </div>
            </div>
            <div class="col-md-4 order-1 order-md-2 reward-custom-padding">
                <div class="single-pricing text-center first-place">
                    <span>1.</span>
                    <h2 class="mb-3">Prvo mesto</h2>
                    <img src="https://hakaton.raf.edu.rs/assets/images/crypto/bitcoin_circle.png" alt="Bitcoin" class="img-fluid crypto-img">
                    <p class="price mt-3" style="line-height:0.8em;">100 000</p>
                    <p class="currency " style="line-height:0.8em;">dinara</p>
                    <p style="font-size:1.3em;" class="mt-5">U Bitcoin kriptovaluti</p>
                </div>
            </div>
            <div class="col-md-4 order-3 order-md-3 reward-custom-padding">
                <div class="single-pricing text-center third-place"
                     data-aos-duration="600">
                    <span>3.</span>
                    <h2 class="mb-3">Treće mesto</h2>
                    <img src="https://hakaton.raf.edu.rs/assets/images/crypto/ethereum_cricle.png" alt="Ethereum" class="img-fluid crypto-img">
                    <p class="price mt-3" style="line-height:0.8em;">25 000</p>
                    <p class="currency " style="line-height:0.8em;">dinara</p>
                    <p style="font-size:1.3em;" class="mt-5">U Ethereum kriptovaluti</p>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="recent-posts sponsors" id="partneri">
    <div class="container">
        <div class="title text-center">
            <h1 class="text-white">Partneri</h1>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="single-rpost d-sm-flex align-items-center justify-content-end">
                    <div class="post-content text-sm-right">
                        <p>Web Development, UI & UX Design, Marketing</p>
                    </div>
                    <div class="post-thumb d-flex justify-content-center">
                        <a href="https://softwarehaus.io/" target="_blank">
                            <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/softwarehaus_logo_centered.png"
                                 alt="Softwarehaus">
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="single-rpost d-sm-flex align-items-center justify-content-start">
                    <div class="post-thumb d-flex justify-content-center">
                        <a href="https://raf.edu.rs/" target="_blank">
                            <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/raf_logo_centered.png" alt="Raf">
                        </a>
                    </div>
                    <div class="post-content">
                        <p>Study, Reasearch, Lab</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer Start -->
<footer>
    <div class="footer-widgets">
        <div class="container">
            <div class="row">
                <div class="col-6 col-xl-3">
                    <div class="single-widget contact-widget">
                        <div class="media">
                            <i class="fa fa-map-marker text-white"></i>
                            <div class="media-body ml-3">
                                <h6>Mesto održavanja</h6>
                                <a href="https://goo.gl/maps/ycUBttET9eLXqLx29" target="_blank" class="footer-link">Računarski
                                    fakultet, <br>
                                    Knez Mihailova 6/VI</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-xl-3">
                    <div class="single-widget contact-widget">
                        <div class="media">
                            <i class="fa fa-envelope-o text-white"></i>
                            <div class="media-body ml-3">
                                <h6>Imate pitanja?</h6>
                                <a href="mailto:hakaton@raf.rs" class="footer-link">hakaton@raf.rs</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-xl-3">
                    <div class="single-widget contact-widget">
                        <div class="media">
                            <i class="fa fa-phone text-white"></i>
                            <div class="media-body ml-3">
                                <h6>Pozovite nas</h6>
                                <a href="tel:011 33 48 079" class="footer-link"> 011 33 48 079</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-xl-3">
                    <div class="single-widget contact-widget">
                        <div class="media">
                            <img style="max-width:150px;" src="https://hakaton.raf.edu.rs/assets/images/Hakaton_logo.png" alt="RAF Hakaton">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="https://hakaton.raf.edu.rs/assets/js/jquery-3.3.1.js?id=1_12"></script>
<script src="https://hakaton.raf.edu.rs/assets/js/bootstrap.bundle.js?id=1_12"></script>
<script src="https://hakaton.raf.edu.rs/assets/js/aos.js?id=1_12"></script>
<script src="https://hakaton.raf.edu.rs/assets/js/matrix.js?id=1_12"></script>
<script src="https://hakaton.raf.edu.rs/assets/js/custom.js?id=1_12"></script>
<script src="https://hakaton.raf.edu.rs/assets/js/main.js?id=1_12"></script>

</body>
</html>